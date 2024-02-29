package info.jiaying.log_transfer_hub.logreceiver;

import info.jiaying.log_transfer_hub.message.LogMessage;

public interface Observer {
    void ONRECEIVE(LogMessage msg);
}
