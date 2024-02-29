package info.jiaying.back_end.event.manager;

import info.jiaying.back_end.event.EventType;
import info.jiaying.back_end.event.listener.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
public class ObserverManager implements ObserverManagerI{
    @Autowired
    private final List<Listener> listeners = new ArrayList<>();
    @Override
    public void dispatch(EventType event, Object... params) throws InvocationTargetException, IllegalAccessException {
        for (Listener listener: listeners) {
            for (Method method: listener.getClass().getMethods()) {
                if (method.getName().equals(event.name())) {
                    method.invoke(listener, params);
                }
            }
        }
    }

    @Override
    public void addReceiver(Listener receiver) {
        listeners.add(receiver);
    }
}
