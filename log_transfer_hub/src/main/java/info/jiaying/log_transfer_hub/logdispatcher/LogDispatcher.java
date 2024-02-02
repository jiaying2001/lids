package info.jiaying.log_transfer_hub.logdispatcher;

import info.jiaying.log_transfer_hub.event.LogEvent;
import info.jiaying.log_transfer_hub.logreceiver.Observer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LogDispatcher implements ObserverManager{
    private final List<Observer> observers = new ArrayList<>();
    @Override
    public void dispatch(LogEvent event, Object... params) throws InvocationTargetException, IllegalAccessException {
        for (Observer observer: observers) {
            for (Method method: observer.getClass().getMethods()) {
                if (method.getName().equals(event.name())) {
                    method.invoke(observer, params);
                }
            }
        }
    }

    @Override
    public void addReceiver(Observer receiver) {
        observers.add(receiver);
    }
}
