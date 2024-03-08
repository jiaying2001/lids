package info.jiaying.back_end.service;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.aggregations.*;
import co.elastic.clients.elasticsearch._types.query_dsl.*;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import info.jiaying.back_end.model.MessageType;
import info.jiaying.back_end.model.TrackHeadNodeLog;
import info.jiaying.back_end.model.TrackTailNodeLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Slf4j
@Service
public class EsService {
    // URL and API key
    static String serverUrl = "http://jiaying.info:9200";
    // Create the low-level client
    static private final RestClient restClient = RestClient
            .builder(HttpHost.create(serverUrl))
            .build();
    static ElasticsearchTransport transport = new RestClientTransport(
            restClient, new JacksonJsonpMapper());

    // And create the API client
    static ElasticsearchClient esClient = new ElasticsearchClient(transport);

   public static long getAllLogsCount(String idx) {
       try {
           SearchResponse<Void> response  = esClient.search(b -> b
                   .index(idx)
                           .size(0)
                           .aggregations("name",
                                   c -> c.cardinality(a -> a.field("trace_id.keyword"))
                                   )
           , Void.class);
       return ((CardinalityAggregate)response.aggregations().get("name")._get()).value();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
    public static double getAvgTime(String idx) {
        try {
            // Search all docs in parsing section
            Query q_ = MatchQuery.of(m -> m
                    .field("node_name")
                    .query("log_hub")
            )._toQuery();

            Query q1_ = MatchQuery.of(m -> m
                    .field("type")
                    .query(MessageType.HEAD.getCode())
            )._toQuery();
//            Further filter by trace_id within trace_ids of docs in notification
//            Logs that involves detection are sampled
            Query tq_ = TermsQuery.of(
                    tq -> tq
                            .field("trace_id.keyword")
                            .terms(
                                    getByAField(idx, "node_name.keyword", "notification")
                            )
            )._toQuery();
            Query cq_ = BoolQuery.of(bq -> bq
                    .must(List.of(q_, q1_, tq_)))._toQuery();
            SearchResponse<Void> r1  = esClient.search(b -> b
                            .index(idx)
                            .size(0)
                            .query(cq_)
                            .aggregations("start", a -> a.avg(c -> c.field("create_time")))
                    , Void.class);
            Query q2 = MatchQuery.of(m -> m
                    .field("node_name")
                    .query("notification")
                    .field("type")
                    .query(MessageType.TAIL.getCode())
            )._toQuery();
            Query cq1_ = BoolQuery.of(bq -> bq
                    .must(List.of(q2, tq_)))._toQuery();
            SearchResponse<Void> r2  = esClient.search(b -> b
                            .index(idx)
                            .size(0)
                            .query(cq1_)
                            .aggregations("end", a -> a.avg(c -> c.field("create_time")))
                    , Void.class);
            return ((AvgAggregate) r2.aggregations().get("end")._get()).value() - ((AvgAggregate) r1.aggregations().get("start")._get()).value();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   public static TermsQueryField getByAField(String idx, String field, String value) {
       Query q1 = MatchQuery.of(m -> m
               .field(field)
               .query(value)
       )._toQuery();
       try {
           SearchResponse<Object> r = esClient.search(b -> b
                           .size(1000)
                   .index(idx)
                   .sort(s -> s
                           .field(v -> v.field("create_time").order(SortOrder.Desc)))
                   .query(q1)
           ,
                   Object.class);
           List<Hit<Object>> hits = r.hits().hits();
           return TermsQueryField.of(tqd -> tqd.value(hits.stream().map(h -> FieldValue.of(((LinkedHashMap<String, String>) h.source()).get("trace_id"))).toList()));
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }

    public static double getNodeAvgTime(String idx, String nodeName) {
        try {
            Query query = MatchQuery.of(m -> m
                    .field("node_name")
                    .query(nodeName)
                    .field("type")
                    .query(MessageType.NODE.getCode())
            )._toQuery();

            Map<String, Aggregation> aggs = new  HashMap<>();
            aggs.put("avg-start-time", Aggregation.of(a -> a.avg(b -> b.field("create_time"))));
            aggs.put("avg-end-time", Aggregation.of(a -> a.avg(b -> b.field("end_time"))));
            SearchResponse<Void> response  = esClient.search(b -> b
                            .index(idx)
                            .size(0)
                            .query(query)
                            .aggregations(aggs)
                    , Void.class);
            double avgCreateTime = ((AvgAggregate)response.aggregations().get("avg-start-time")._get()).value();
            double avgEndTime = ((AvgAggregate)response.aggregations().get("avg-end-time")._get()).value();
            return (avgEndTime - avgCreateTime);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
//        EsService.getDetectAvgTime("2");
        EsService.getTransactionByUserIdAndUuid(2, "cc50a440-3c95-4223-8cb2-9da69463aa21");
   }

    public static List<Map<String, String>> getTransactionByUserIdAndUuid(int userId, String traceUuid) {
        try {
            // Get log of TAIL type for the trace uuid
            Query matchTraceId = MatchQuery.of(m -> m
                    .field("trace_id.keyword")
                    .query(traceUuid)
            )._toQuery();
            Query matchType = MatchQuery.of(m -> m
                    .field("type")
                    .query(MessageType.TAIL.getCode())
            )._toQuery();
            Query query = BoolQuery.of(
                    bq -> bq.
                            must(
                                    List.of(matchTraceId, matchType)
                            )
            )._toQuery();
            SearchResponse<Object> sr = esClient.search(q -> q
                            .index(String.valueOf(userId))
                            .size(1)
                            .query(query)
                , Object.class);
            Map<String, String> log = (Map<String, String>) sr.hits().hits().get(0).source();
            List<Query> queries =buildMatchQueries(
                    "path.keyword", log.get("path"),
                    "app_name.keyword", log.get("app_name"),
                    "type", String.valueOf(MessageType.TAIL.getCode())
            );
            queries.add(RangeQuery.of(
                            rq -> rq
                                    .field("create_time")
                                    .lte(JsonData.of(String.valueOf(log.get("create_time"))))
                                    )._toQuery());
            Query q2 = BoolQuery.of(bq -> bq
                    .must(queries)
            )._toQuery();
            SearchResponse sr1 = esClient.search(q -> q
                            .size(2)
                            .sort(
                                    s -> s
                                            .field(
                                                    f -> f
                                                            .field("create_time")
                                                            .order(SortOrder.Desc)
                                            )
                            )
                            .query(q2)
                    , Object.class);
           List<Query> qs3 =buildMatchQueries(
                    "path.keyword", log.get("path"),
                    "app_name.keyword", log.get("app_name"),
                    "type", String.valueOf(MessageType.HEAD.getCode())
           );
           List<Hit> hits = sr1.hits().hits();

            qs3.add(RangeQuery.of(
                    rq -> rq
                            .field("create_time")
                            .lt(
                                    JsonData.of(
                                            String.valueOf(
                                                    getDocByTraceIdAndType(
                                                            ((Map<String, String>)hits.get(0).source()).get("trace_id"), MessageType.HEAD
                                                    ).get("create_time")
                                            )
                                    )
                            )
                            .gte(
                                    JsonData.of(
                                            String.valueOf(
                                                    getDocByTraceIdAndType(
                                                            ((Map<String, String>)hits.get(1).source()).get("trace_id"), MessageType.HEAD
                                                    ).get("create_time")
                                            )
                                    )
                            )
                )._toQuery());
            Query q3 = BoolQuery.of(
                    bq -> bq.
                            must(
                                    qs3
                            )
            )._toQuery();
            SearchResponse<Object> sr2 = esClient.search(
                    sq -> sq
                            .sort(
                                    s -> s
                                            .field(
                                                    f -> f
                                                            .field("create_time")
                                                            .order(SortOrder.Desc)
                                            )
                            )
                            .query(q3)
                    , Object.class);
            return sr2.hits().hits().stream().map(hit -> ((Map<String, String>)hit.source())).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<String, String> getDocByTraceIdAndType(String traceId, MessageType messageType) {
       return buildSearch(buildBoolMust(buildMatchQueries(
               "trace_id", traceId,
               "type", String.valueOf(messageType.getCode())
       ))).get(0);
    }
    public static List<Map<String, String>> buildSearch(Query query) {
        try {
            SearchResponse<Object> sr =  esClient.search(
                    s -> s
                            .query(query)
            , Object.class);
            return sr.hits().hits().stream().map(
              hit -> (Map<String, String>) hit.source()
            ).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Query buildBoolMust(List<Query> queries) {
       return BoolQuery.of(
               bq -> bq
                       .must(queries)
       )._toQuery();
    }

    public static  List<Query> buildMatchQueries(String field, String value, String... params) {
        List<Query> queries = new ArrayList<>(params.length / 2 + 1);
        queries.add(buildMatchQuery(field, value));
        for (int i = 0; i < params.length; i += 2) {
            field = params[i];
            value = params[i + 1];
            if (field != null && value != null) {
                queries.add(buildMatchQuery(field, value));
            }
        }
        return queries;
    }

    public static Query buildMatchQuery(String field, String value) {
       return MatchQuery.of(m -> m
               .field(field)
               .query(value)
       )._toQuery();
    }


//    public static List<> getTransactionByUuid(String traceUuid) {
//    }
}

