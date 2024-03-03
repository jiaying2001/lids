package info.jiaying.http;

import info.jiaying.dto.CommonResponse;
import info.jiaying.model.Task;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ServerInterface {
    byte[] loadFileByFilename(String fileName);

    List<Task> getTaskList(String taskType, int status, int limit);

    // 获取任务配置信息
    CommonResponse getTaskTypeCfgList();

    void setTask(Task task);

    String uploadFile(String file);
}
