package info.jiaying.log_transfer_hub.util.kafka.client;

import com.alibaba.fastjson2.JSONObject;
import info.jiaying.log_transfer_hub.message.LogTransactionMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Slf4j
public class KafkaClient {
    static KafkaConsumer<String, String> consumer;

    static {
        Properties props = new Properties();
//        props.put("bootstrap.servers", "124.221.34.29:9092");
        props.put("bootstrap.servers", "jiaying.info:9092");
        props.put("group.id", "l3");
        props.put("enable.auto.commit", "true");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("max.poll.records", 1);
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("log_queue"));
    }

    static Producer<String, String> producer;

    static {
        Properties props = new Properties();
//        props.put("bootstrap.servers", "124.221.34.29:9092");
        props.put("bootstrap.servers", "jiaying.info:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(props);
    }

    static public String get() {
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
        if (!records.isEmpty()) {
            for (ConsumerRecord<String, String> record : records) {
                log.info("Received a message: " + record.value());
                return record.value();
            }
        }
        return null;
    }

    static public void send(String topic, String value) {
        log.info("Sent " + value + " to "  + topic);
        producer.send(new ProducerRecord<>(topic, value));
    }

    static public void send(String topic, Object value) {
        log.info("Sent " + value + " to "  + topic);
        System.out.println(JSONObject.toJSONString((LogTransactionMessage) value));
        producer.send(new ProducerRecord<>(topic,  JSONObject.toJSONString(value)));
    }

}
