package info.jiaying.log_transfer_hub.logdispatcher;

import info.jiaying.log_transfer_hub.event.LogEvent;
import info.jiaying.log_transfer_hub.logreceiver.Observer;

import java.lang.reflect.InvocationTargetException;

public interface ObserverManager {
    void dispatch(LogEvent event, Object... params) throws InvocationTargetException, IllegalAccessException;
    void addReceiver(Observer receiver);
}
