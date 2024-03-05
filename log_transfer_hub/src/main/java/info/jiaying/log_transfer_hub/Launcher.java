package info.jiaying.log_transfer_hub;

import com.alibaba.fastjson2.JSONObject;
import info.jiaying.log_transfer_hub.logparser.PIDLogParser;
import info.jiaying.log_transfer_hub.logreceiver.TraceReceiver;
import info.jiaying.log_transfer_hub.logreceiver.TransactionLogReceiver;
import info.jiaying.log_transfer_hub.message.LogMessage;
import info.jiaying.log_transfer_hub.util.kafka.client.KafkaClient;
import info.jiaying.log_transfer_hub.event.LogEvent;
import info.jiaying.log_transfer_hub.logdispatcher.LogDispatcher;
import info.jiaying.log_transfer_hub.logdispatcher.ObserverManager;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Launcher {
    private final ObserverManager logDispatcher = new LogDispatcher();

    public Launcher() {
//        logDispatcher.addReceiver(new LogReceiver());
        logDispatcher.addReceiver(new TraceReceiver());
        logDispatcher.addReceiver(new TransactionLogReceiver());
    }

    public void launch() throws InvocationTargetException, IllegalAccessException, InterruptedException {
        for (;;) {
            String msg = KafkaClient.get();
            if (msg != null) {
               LogMessage logMessage = JSONObject.parseObject(msg, LogMessage.class);
               logMessage.getHeader().setTopic(logMessage.getHeader().getOs() + "_" + logMessage.getHeader().getAppName() + "_public");
               logDispatcher.dispatch(LogEvent.ONRECEIVE, logMessage);
                logDispatcher.dispatch(LogEvent.ONFINISH, (Object) null);
            }
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        try {
            new Launcher().launch();
        } catch (InvocationTargetException | IllegalAccessException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
