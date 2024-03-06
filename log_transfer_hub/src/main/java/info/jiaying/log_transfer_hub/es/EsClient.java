package info.jiaying.log_transfer_hub.es;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import java.io.IOException;

@Slf4j
public class EsClient {
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

    public static void createIdx(String idx) throws IOException {
        esClient.indices().create(c -> c
                .index(idx)
        );
    }


    public static void deleteIdx(String idx) throws IOException {
        esClient.indices().delete(c -> c.index(idx));
    }

    public static void indexDoc(String idx, String id, Object o) throws IOException {
        IndexResponse resp = esClient.index(i -> i
                .index(String.valueOf(idx))
                .id(id)
                .document(o)
        );
    }

    public static void getDoc(String idx, String id, Class<?> clazz) throws IOException {
        GetResponse<?> resp = resp = esClient.get(g -> g
                        .index(idx)
                        .id(id),
                clazz
        );
        if (resp.found()) {
            log.info(resp.source().toString());
        } else {
        }
    }

    public static void main(String[] args) throws IOException {
    }

}
