package info.jiaying.back_end.api.task;

import cn.hutool.core.util.StrUtil;
import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.TaskParams;
import info.jiaying.back_end.model.Task;
import info.jiaying.back_end.model.TaskMetaCfg;
import info.jiaying.back_end.service.TaskMetaCfgService;
import info.jiaying.back_end.service.TaskService;
import info.jiaying.back_end.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    TaskMetaCfgService taskMetaCfgService;
    @Autowired
    UserService userService;
    @PostMapping
    public CommonResponse createTask(@RequestBody TaskParams taskParams, @AuthenticationPrincipal UserDetails userDetails) {
        if (StrUtil.isEmpty(taskParams.getTask_type())){
            log.error("input invalid");
            return CommonResponse.fail(100, "ERR_INPUT_INVALID");
        }
        int userId = userService.getUserIdByName(userDetails.getUsername());
        taskParams.setUser_id(Integer.toString(userId));
        TaskMetaCfg cfg = taskMetaCfgService.getTaskMetaCfg(taskParams.getTask_type());
        return CommonResponse.success("task_id", taskService.createTask(taskParams, cfg));
    }

    @GetMapping
    public CommonResponse get(@RequestParam("task_uuid") String uuid) {
        return CommonResponse.success(taskService.get(uuid));
    }

    @GetMapping("/tasks")
    public CommonResponse getTasks(@RequestParam("task_type") String taskType, @RequestParam("task_stage") String taskStage, @RequestParam("status") int status, @RequestParam("limit") int limit){
        return CommonResponse.success(taskService.getTasks(taskType, taskStage, status, limit));
    }

    @PostMapping("/tasks")
    public CommonResponse updateTasks(@RequestBody List<Task> tasks) {
        taskService.updateTasks(tasks);
        return CommonResponse.success();
    }

    @PostMapping("/task/update")
    public CommonResponse update(@RequestBody Task task) {
        taskService.update(task);
        return CommonResponse.success();
    }

}
