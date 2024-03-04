package info.jiaying.log_transfer_hub.logreceiver;

import cn.hutool.core.bean.BeanUtil;
import info.jiaying.es.EsClient;
import info.jiaying.log_transfer_hub.message.LogMessage;
import info.jiaying.message.MessageType;
import info.jiaying.message.TrackHeadNodeLog;
import info.jiaying.message.TrackNodeLog;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class TraceReceiver implements Observer{
    TrackHeadNodeLog singleStore = null;
    @Override
    public void ONRECEIVE(LogMessage msg) {
        TrackHeadNodeLog log1 = TrackHeadNodeLog.builder()
                .node_name("log_hub")
                .user_id(String.valueOf(msg.getHeader().getUserId()))
                .trace_id(msg.getHeader().getTraceId())
                .count(msg.getHeader().getCount())
                .type(MessageType.HEAD.getCode())
                .create_time(System.currentTimeMillis())
                .log(msg.getBody().getContent())
                .build();
        singleStore = log1;
        try {
            EsClient.indexDoc(log1.getUser_id(), log1.getTrace_id() + "_" + log1.getCount(), log1);
        } catch (IOException e) {
            log.error("Error sending to elasticsearch");
        }
    }

    @Override
    public void ONFINISH(TrackHeadNodeLog l) {
        TrackNodeLog nl = TrackNodeLog.builder().end_time(System.currentTimeMillis()).build();
        BeanUtil.copyProperties(singleStore, nl);
        nl.setType(MessageType.NODE.getCode());
    }
}
