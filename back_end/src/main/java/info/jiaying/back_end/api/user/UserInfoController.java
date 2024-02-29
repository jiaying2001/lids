package info.jiaying.back_end.api.user;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.UserInfoParams;
import info.jiaying.back_end.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.cert.CertPath;

@RestController
@RequestMapping("/api/user/info")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    @GetMapping()
    public CommonResponse get() {
        return CommonResponse.success(userInfoService.get());
    }

    @PostMapping()
    public CommonResponse post(@RequestBody UserInfoParams params) {
        userInfoService.add(params);
        return CommonResponse.success();
    }

}
