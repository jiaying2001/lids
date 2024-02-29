package info.jiaying.back_end.event.manager;

import info.jiaying.back_end.event.EventType;
import info.jiaying.back_end.event.listener.Listener;

import java.lang.reflect.InvocationTargetException;

public interface ObserverManagerI {
    void dispatch(EventType event, Object... params) throws InvocationTargetException, IllegalAccessException;

    void addReceiver(Listener receiver);
}
