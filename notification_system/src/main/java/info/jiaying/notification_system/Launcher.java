package info.jiaying.notification_system;

import com.alibaba.fastjson2.JSONObject;
import info.jiaying.notification_system.event.LogEvent;
import info.jiaying.notification_system.event.listener.AuditListener;
import info.jiaying.notification_system.logdispatcher.LogDispatcher;
import info.jiaying.notification_system.logdispatcher.ObserverManager;
import info.jiaying.notification_system.message.LogMessage;
import info.jiaying.notification_system.utile.client.KafkaClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.InvocationTargetException;

@SpringBootApplication
public class Launcher {
    private final ObserverManager logDispatcher = new LogDispatcher();

    public Launcher() {
        logDispatcher.addReceiver(new AuditListener());
    }

    public void launch() throws InvocationTargetException, IllegalAccessException, InterruptedException {
        for (; ; ) {
            String msg = KafkaClient.get();
            if (msg != null) {
                LogMessage logMessage = JSONObject.parseObject(msg, LogMessage.class);
                logDispatcher.dispatch(LogEvent.ONRECEIVE, logMessage);
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
