package info.jiaying.log_transfer_hub.logreceiver;

import cn.hutool.core.bean.BeanUtil;
import info.jiaying.log_transfer_hub.es.EsClient;
import info.jiaying.log_transfer_hub.message.LogMessage;
import info.jiaying.log_transfer_hub.message.MessageType;
import info.jiaying.log_transfer_hub.message.TrackHeadNodeLog;
import info.jiaying.log_transfer_hub.message.TrackNodeLog;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class TraceReceiver implements Observer{
    TrackHeadNodeLog singleStore = null;
    @Override
    public void ONRECEIVE(LogMessage msg) {
        TrackHeadNodeLog log1 = TrackHeadNodeLog.builder()
                .app_name(msg.getHeader().getAppName())
                .node_name("log_hub")
                .user_id(String.valueOf(msg.getHeader().getUserId()))
                .trace_id(msg.getHeader().getTraceId())
                .count(msg.getHeader().getCount())
                .type(MessageType.HEAD.getCode())
                .create_time(System.currentTimeMillis())
                .log(msg.getBody().getContent())
                .path(msg.getHeader().getPath())
                .build();
        singleStore = log1;
        try {
            log.info("Sending {} to ES", log1.getTrace_id());
            EsClient.indexDoc(log1.getUser_id(), log1.getTrace_id() + "_" + log1.getCount() + "_" + log1.getType(), log1);
        } catch (IOException e) {
            log.error("Error sending to elasticsearch");
        }
    }

    @Override
    public void ONFINISH(LogMessage l) {
        TrackNodeLog nl = TrackNodeLog.builder().end_time(System.currentTimeMillis()).build();
        BeanUtil.copyProperties(singleStore, nl);
        nl.setType(MessageType.NODE.getCode());
        try {
            log.info("Sending {} to ES", nl.getTrace_id());
            EsClient.indexDoc(nl.getUser_id(), nl.getTrace_id() + "_" + nl.getCount()+ "_" + nl.getType(), nl);
        } catch (IOException e) {
            log.error("Error sending to elasticsearch");
        }
    }
}
