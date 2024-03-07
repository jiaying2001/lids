package info.jiaying.back_end.service;

import info.jiaying.back_end.dto.TraceParams;
import info.jiaying.back_end.model.Trace;

import java.util.List;

public interface TraceService {
    List<Trace> getByStatus(int status);

    void create(TraceParams traceParams);
}
