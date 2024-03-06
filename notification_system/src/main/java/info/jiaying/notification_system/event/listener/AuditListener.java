package info.jiaying.notification_system.event.listener;

import info.jiaying.notification_system.es.EsClient;
import info.jiaying.notification_system.message.LogMessage;
import info.jiaying.notification_system.logreceiver.Observer;
import info.jiaying.notification_system.message.MessageType;
import info.jiaying.notification_system.message.TrackTailNodeLog;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class AuditListener implements Observer {
    @Override
    public void ONRECEIVE(LogMessage msg) {
        TrackTailNodeLog log1 = TrackTailNodeLog.builder()
                .node_name("notification")
                .path(msg.getHeader().getPath())
                .user_id(String.valueOf(msg.getHeader().getUserId()))
                .trace_id(msg.getHeader().getTraceId())
                .count(msg.getHeader().getCount())
                .type(MessageType.TAIL.getCode())
                .create_time(System.currentTimeMillis())
                .build();
        try {
            EsClient.indexDoc(log1.getUser_id(), log1.getTrace_id() + "_" + log1.getCount() + "_" + log1.getType(), log1);
        } catch (IOException e) {
            log.error("Error sending to elasticsearch");
        }
    }

    @Override
    public void ONFINISH(LogMessage l) {

    }
}
