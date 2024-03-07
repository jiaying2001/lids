package info.jiaying.back_end.service.impl;

import cn.hutool.core.bean.BeanUtil;
import info.jiaying.back_end.dto.TraceParams;
import info.jiaying.back_end.mapper.TraceMapper;
import info.jiaying.back_end.model.Trace;
import info.jiaying.back_end.model.TraceExample;
import info.jiaying.back_end.service.TraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TraceServiceImpl implements TraceService {
    @Autowired
    TraceMapper traceMapper;
    @Override
    public List<Trace> getByStatus(int status) {
        TraceExample e = getNewExample();
        e.createCriteria().andStatusEqualTo(status);
        return traceMapper.selectByExample(e);
    }

    @Override
    public void create(TraceParams traceParams) {
        Trace t = new Trace();
        BeanUtil.copyProperties(traceParams, t);
        t.setCreateTime(new Date());
        traceMapper.insertSelective(t);
    }

    TraceExample E = new TraceExample();
    private TraceExample getNewExample() {
        E.clear();
        return E;
    }
}
