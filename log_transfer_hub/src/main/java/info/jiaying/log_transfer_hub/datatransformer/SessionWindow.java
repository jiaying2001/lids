package info.jiaying.log_transfer_hub.datatransformer;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import info.jiaying.log_transfer_hub.model.Log;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SessionWindow {
    private final int WINDOW_SIZE;

    private final long SESSION_TIMEOUT;

    private final DateUnit TIME_UNIT;

    private Deque<Log> sessionGroup = new LinkedList<>();

    public SessionWindow(int WINDOW_SIZE, long SESSION_TIMEOUT, DateUnit TIME_UNIT) {
        this.WINDOW_SIZE = WINDOW_SIZE;
        this.SESSION_TIMEOUT = SESSION_TIMEOUT;
        this.TIME_UNIT = TIME_UNIT;
    }

    public List<List<Integer>> transform(Log log) {
        // when there is insufficient logs in the group for extracting the previous sequence of size WINDOW_SIZE,
        // default to treat the current input log as normal
        if (sessionGroup.size() < WINDOW_SIZE) {
            sessionGroup.addLast(log);
            return null;
        }
        if (doesBelongToCurrentSession(log)) {
            List<List<Integer>> output = new ArrayList<>();
            output.add(sessionGroup.stream().map(Log::getEventType).toList());
            output.add(List.of(log.getEventType()));
            sessionGroup.removeFirst();
            sessionGroup.addLast(log);
            return output;
        } else {
            sessionGroup = new LinkedList<>();
            sessionGroup.addLast(log);
        }
        return null;
    }

    private boolean doesBelongToCurrentSession(Log log) {
        Log lastLog = sessionGroup.peekLast();
        if (lastLog != null) {
            return DateUtil.between(log.getEventTime(), lastLog.getEventTime(), TIME_UNIT) < SESSION_TIMEOUT;
        }
        return false;
    }
}
