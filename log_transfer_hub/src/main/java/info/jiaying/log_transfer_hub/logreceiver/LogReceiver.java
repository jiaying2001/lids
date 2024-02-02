package info.jiaying.log_transfer_hub.logreceiver;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson2.JSONObject;
import info.jiaying.log_transfer_hub.util.kafka.client.KafkaClient;
import info.jiaying.log_transfer_hub.datatransformer.SessionWindow;
import info.jiaying.log_transfer_hub.logparser.DrainLogParser;
import info.jiaying.log_transfer_hub.model.Log;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogReceiver implements Observer{
    private final DrainLogParser parser = new DrainLogParser(List.of(), 5, 100, 0.5);

    private final SessionWindow sessionWindow = new SessionWindow(10, 1, DateUnit.MINUTE);

    @Override
    public void ONRECEIVE(String logJson) {
        JSONObject logJsonObject = JSONObject.parseObject(logJson);
        Log logObject = logJsonObject.toJavaObject(Log.class);
        logObject.setEventType(parser.parseLogLine(logObject.getMessage(), "0").getEventId());
        logObject.setProcessingTime(DateUtil.parse((String) logJsonObject.get("@timestamp")));
        Pattern pattern = Pattern.compile("\\b(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\b");
        Matcher matcher = pattern.matcher(logObject.getMessage());
        if (matcher.find()) {
            logObject.setEventTime(DateUtil.parse(matcher.group(), "MMM dd HH:mm:ss"));
        }
        List<List<Integer>> output = sessionWindow.transform(logObject);
        if (output != null) {
            KafkaClient.send("SessionWindow", JSONObject.toJSONString(output));
        }
    }
}
