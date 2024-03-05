package info.jiaying.back_end.service.impl;

import info.jiaying.back_end.dto.IdsParams;
import info.jiaying.back_end.mapper.IdsMapper;
import info.jiaying.back_end.model.Ids;
import info.jiaying.back_end.model.IdsExample;
import info.jiaying.back_end.service.IdsService;
import org.apache.zookeeper.data.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdsServiceImpl implements IdsService {
    @Autowired
    IdsMapper idsMapper;
    @Override
    public void update(IdsParams idsParams) {

    }

    @Override
    public Ids get(int idsId) {
        return idsMapper.selectByPrimaryKey(idsId);
    }

    @Override
    public Object getAll() {
        IdsExample e = new IdsExample();
        return idsMapper.selectByExample(e);
    }
}
