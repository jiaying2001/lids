package info.jiaying.back_end.service.impl;

import info.jiaying.back_end.mapper.TaskMetaCfgMapper;
import info.jiaying.back_end.model.TaskMetaCfg;
import info.jiaying.back_end.model.TaskMetaCfgExample;
import info.jiaying.back_end.service.TaskMetaCfgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskMetaCfgServiceImpl implements TaskMetaCfgService {
    @Autowired
    TaskMetaCfgMapper taskMetaCfgMapper;
    @Override
    public TaskMetaCfg getTaskMetaCfg(String taskType) {
        return taskMetaCfgMapper.selectByPrimaryKey(taskType);
    }
}
