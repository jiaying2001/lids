package info.jiaying.back_end.api.es;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.service.EsService;
import info.jiaying.back_end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/es")
public class EsController {
    @Autowired
    UserService userService;
    @GetMapping("/total-logs-count")
    public CommonResponse getTotalCountOfLogs(@AuthenticationPrincipal UserDetails userDetails) {
        return CommonResponse.success(EsService.getAllLogsCount(String.valueOf(userService.getUserIdByName(userDetails.getUsername()))));
    }

    @GetMapping("/node-avg-time")
    public CommonResponse getParseAvgTime(@RequestParam("node-name") String nodeName, @AuthenticationPrincipal UserDetails userDetails) {
        return CommonResponse.success(EsService.getNodeAvgTime(String.valueOf(userService.getUserIdByName(userDetails.getUsername())), nodeName));
    }
    @GetMapping("/avg-time")
    public CommonResponse getAvgTime(@AuthenticationPrincipal UserDetails userDetails) {
        return CommonResponse.success(EsService.getAvgTime(String.valueOf(userService.getUserIdByName(userDetails.getUsername()))));
    }
}
