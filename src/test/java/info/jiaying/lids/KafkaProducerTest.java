package info.jiaying.lids;


import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Builder;
import lombok.Data;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.assertj.core.util.DateUtil;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

class KafkaProducerTest {
    private static List<Log> logStore;

    private static String jwtToken = "";

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "124.221.34.29:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);

        // Init store
        fillLogStore();
        for (Log log: logStore) {
//            System.out.println(JSONObject.toJSONString(log));
            producer.send(new ProducerRecord<>("test", JSONObject.toJSONString(log)));
        }

    }

    public static void fillLogStore() {
        logStore = new ArrayList<>() {{
           add(Log.builder()
                   .message("Jun  1 22:20:05 secserv kernel: Kernel logging (proc) stopped")
                   .path("/var/log/sys.log")
                   .timestamp(DateUtil.now())
                   .jwtToken(jwtToken)
                   .build());
           add(Log.builder()
                   .message("Jun  1 22:20:05 secserv kernel: Kernel log daemon terminating.")
                   .path("/var/log/sys.log")
                   .timestamp(DateUtil.now())
                   .jwtToken(jwtToken)
                   .build());
           add(Log.builder()
                   .message("Jun  1 22:20:06 secserv exiting on signal 15")
                   .path("/var/log/sys.log")
                   .timestamp(DateUtil.now())
                   .jwtToken(jwtToken)
                   .build());
           add(Log.builder()
                   .message("Nov 27 08:05:57 galileo kernel: Kernel logging (proc) stopped.")
                   .path("/var/log/sys.log")
                   .timestamp(DateUtil.now())
                   .jwtToken(jwtToken)
                   .build());
        }};
    }

    @Builder
    @Data
    public static class Log {
        @JSONField(name = "@timestamp")
        Date timestamp;
        String message;
        String messageLen;
        String path;
        Date eventTime;
        int eventType = -1;
        String jwtToken;
    }
}