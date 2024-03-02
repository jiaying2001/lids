package info.jiaying.http;

import info.jiaying.dto.CommonResponse;


public interface ServerInterface {
    CommonResponse getTaskList(String taskType, int status, int limit);
    CommonResponse setTask();

    // 获取任务配置信息
    CommonResponse getTaskTypeCfgList();
}
