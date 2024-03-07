package info.jiaying.back_end.service;

import info.jiaying.back_end.dto.TaskParams;
import info.jiaying.back_end.model.Task;
import info.jiaying.back_end.model.TaskMetaCfg;

import java.util.List;

public interface TaskService {
    String createTask(TaskParams taskParams, TaskMetaCfg cfg);

    Task get(String uuid);

    void updateTasks(List<Task> tasks);

    List<Task> getTasks(String taskType, int status, int limit);

    void update(Task task);

    List<Task> getExecutingTasks(int userId);
}
