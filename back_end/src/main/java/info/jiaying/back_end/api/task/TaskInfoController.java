package info.jiaying.back_end.api.task;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.service.TaskService;
import info.jiaying.back_end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task/info")
public class TaskInfoController {
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    @GetMapping
    public CommonResponse getExecutingTasks() {
        return CommonResponse.success(taskService.getExecutingTasks(userService.getUserId()));
    }

}
