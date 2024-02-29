package info.jiaying.log_transfer_hub.logreceiver;

import cn.hutool.core.date.DateUnit;
import info.jiaying.log_transfer_hub.message.LogMessage;
import info.jiaying.log_transfer_hub.datatransformer.SessionWindow;
import info.jiaying.log_transfer_hub.logparser.DrainLogParser;

public class LogReceiver implements Observer{
    private final DrainLogParser parser = new DrainLogParser(5, 100, 0.5F);

    private final SessionWindow sessionWindow = new SessionWindow(10, 1, DateUnit.MINUTE);

    @Override
    public void ONRECEIVE(LogMessage msg) {
//        JSONObject logJsonObject = JSONObject.parseObject(logJson);
//        Log logObject = logJsonObject.toJavaObject(Log.class);
//        logObject.setEventType(parser.parseLogLine(logObject.getMessage()));
//        logObject.setProcessingTime(DateUtil.parse((String) logJsonObject.get("@timestamp")));
//        Pattern pattern = Pattern.compile("\\b(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)\\s\\d{2}\\s\\d{2}:\\d{2}:\\d{2}\\b");
//        Matcher matcher = pattern.matcher(logObject.getMessage());
//        if (matcher.find()) {
//            logObject.setEventTime(DateUtil.parse(matcher.group(), "MMM dd HH:mm:ss"));
//        }
//        List<List<Integer>> output = sessionWindow.transform(logObject);
//        System.out.println(output);
//        if (output != null) {
//            KafkaClient.send("SessionWindow", JSONObject.toJSONString(output));
//        }
    }
}
