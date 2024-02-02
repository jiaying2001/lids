package info.jiaying.back_end.api.user;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.UserLoginParams;
import info.jiaying.back_end.dto.UserSignUpParams;
import info.jiaying.back_end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public CommonResponse register(@RequestBody UserSignUpParams userSignUpParams) {
        userService.register(userSignUpParams);
        return new CommonResponse();
    }

    @PostMapping("/login")
    public CommonResponse login(@RequestBody UserLoginParams request) {
        return new CommonResponse();
    }
}
