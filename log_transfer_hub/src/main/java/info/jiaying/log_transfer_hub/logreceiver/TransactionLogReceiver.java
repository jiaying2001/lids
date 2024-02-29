package info.jiaying.log_transfer_hub.logreceiver;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import info.jiaying.log_transfer_hub.logparser.PIDLogParser;
import info.jiaying.log_transfer_hub.message.LogMessage;
import info.jiaying.log_transfer_hub.util.kafka.client.KafkaClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionLogReceiver implements Observer{
    Map<String, PIDLogParser> parsers = new HashMap<>();
    @Override
    public void ONRECEIVE(LogMessage msg) {
        if (msg.getProperty().getStartTimestamp() == null) {
            msg.getProperty().setStartTimestamp(new ArrayList<>());
        }
        if (msg.getProperty().getEndTimestamp() == null) {
            msg.getProperty().setEndTimestamp(new ArrayList<>());
        }
        String topic = msg.getHeader().getTopic();
        if (!parsers.containsKey(topic)) {
            parsers.put(topic, new PIDLogParser());
        }
        PIDLogParser parser = parsers.get(topic);
        msg.getProperty().getStartTimestamp().add(System.currentTimeMillis());
        List<Integer> logGroup =  parser.parseLogLine(msg.getHeader().getPid(), msg.getBody().getContent());
        msg.getProperty().getEndTimestamp().add(System.currentTimeMillis());
        if (logGroup != null) {
           msg.getBody().setContent(JSONObject.toJSONString(logGroup));
            KafkaClient.send(topic, JSONObject.toJSONString(msg));
        }
    }
}
