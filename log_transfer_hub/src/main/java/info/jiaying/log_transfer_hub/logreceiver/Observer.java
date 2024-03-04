package info.jiaying.log_transfer_hub.logreceiver;

import info.jiaying.log_transfer_hub.message.LogMessage;
import info.jiaying.message.TrackHeadNodeLog;

public interface Observer {
    void ONRECEIVE(LogMessage msg);

    void ONFINISH(TrackHeadNodeLog l);
}
