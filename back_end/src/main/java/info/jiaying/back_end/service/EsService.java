package info.jiaying.back_end.service;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.aggregations.*;
import co.elastic.clients.elasticsearch._types.query_dsl.*;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import info.jiaying.back_end.model.MessageType;
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
   }

}

