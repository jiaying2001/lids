package info.jiaying.notification_system.logdispatcher;

import info.jiaying.notification_system.event.LogEvent;
import info.jiaying.notification_system.logreceiver.Observer;

import java.lang.reflect.InvocationTargetException;

public interface ObserverManager {
    void dispatch(LogEvent event, Object... params) throws InvocationTargetException, IllegalAccessException;
    void addReceiver(Observer receiver);
}
