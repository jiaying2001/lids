package info.jiaying.log_transfer_hub;

import info.jiaying.log_transfer_hub.util.kafka.client.KafkaClient;
import info.jiaying.log_transfer_hub.event.LogEvent;
import info.jiaying.log_transfer_hub.logdispatcher.LogDispatcher;
import info.jiaying.log_transfer_hub.logdispatcher.ObserverManager;
import info.jiaying.log_transfer_hub.logreceiver.LogReceiver;

import java.lang.reflect.InvocationTargetException;

public class Launcher {
    private final ObserverManager logDispatcher = new LogDispatcher();

    public Launcher() {
        logDispatcher.addReceiver(new LogReceiver());
    }

    public void launch() throws InvocationTargetException, IllegalAccessException, InterruptedException {
        for (;;) {
            String logJson = KafkaClient.get();
            if (logJson != null) {
                logDispatcher.dispatch(LogEvent.ONRECEIVE, logJson);
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
