package info.jiaying.notification_system.logreceiver;


import info.jiaying.notification_system.message.LogMessage;

public interface Observer {
    void ONRECEIVE(LogMessage msg);

    void ONFINISH(LogMessage msg);
}
