package info.jiaying.notification_system.event.listener;

import info.jiaying.log_transfer_hub.logreceiver.Observer;
import info.jiaying.log_transfer_hub.message.LogMessage;

import java.util.List;

public class AuditListener implements Observer {
    @Override
    public void ONRECEIVE(LogMessage msg) {
        List<Long> startTimestamp = msg.getProperty().getStartTimestamp();
        List<Long> endTimestamp = msg.getProperty().getEndTimestamp();
        long diff = endTimestamp.get(endTimestamp.size() - 1) - startTimestamp.get(0);
        System.out.println(diff);
    }
}
