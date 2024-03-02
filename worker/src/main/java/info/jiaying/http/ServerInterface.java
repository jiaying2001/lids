package info.jiaying.http;

import info.jiaying.dto.CommonResponse;
import info.jiaying.model.Task;

import java.util.List;


public interface ServerInterface {
    List<Task> getTaskList(String taskType, int status, int limit);

    // 获取任务配置信息
    CommonResponse getTaskTypeCfgList();

    void setTask(Task task);
}
