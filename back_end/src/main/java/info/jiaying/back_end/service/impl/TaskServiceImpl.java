package info.jiaying.back_end.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import info.jiaying.back_end.dto.TaskParams;
import info.jiaying.back_end.mapper.TaskMapper;
import info.jiaying.back_end.model.Task;
import info.jiaying.back_end.model.TaskExample;
import info.jiaying.back_end.model.TaskMetaCfg;
import info.jiaying.back_end.model.TaskStatus;
import info.jiaying.back_end.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;
    @Override
    public String createTask(TaskParams taskParams, TaskMetaCfg cfg) {
        Task task = new Task();
        BeanUtil.copyProperties(taskParams, task, true);
        BeanUtil.copyProperties(cfg, task, true);
        task.setTaskUuid(UUID.randomUUID().toString());
        task.setCreateTime(Instant.now().toEpochMilli());
        task.setOrderTime(Instant.now().toEpochMilli());
        task.setModifyTime(0L);
        taskMapper.insert(task);
        return task.getTaskUuid();
    }

    @Override
    public Task get(String uuid) {
        TaskExample e = new TaskExample();
        e.createCriteria().andTaskUuidEqualTo(uuid);
        return taskMapper.selectByExample(e).get(0);
    }

    @Override
    public void updateTasks(List<Task> tasks) {
        for (Task task: tasks) {
            taskMapper.updateByPrimaryKeySelective(task);
        }
    }

    @Override
    public List<Task> getTasks(String taskType, int status, int limit) {
        return taskMapper.selectWithLimit(taskType, status, limit);
    }

    @Override
    public void update(Task task) {
        taskMapper.updateByPrimaryKey(task);
    }

    @Override
    public List<Task> getExecutingTasks(int userId) {
        TaskExample e = getNewTaskExample();
        e.createCriteria().andUserIdEqualTo(String.valueOf(userId)).andStatusNotEqualTo((byte) TaskStatus.SUCCESS.getStatus());
        return taskMapper.selectByExample(e);
    }

    TaskExample TE = new TaskExample();

    private TaskExample getNewTaskExample() {
        TE.clear();
        return TE;
    }
}
