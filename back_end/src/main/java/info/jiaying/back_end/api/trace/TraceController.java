package info.jiaying.back_end.api.trace;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.TraceParams;
import info.jiaying.back_end.service.TraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trace")
public class TraceController {
    @Autowired
    TraceService traceService;
    @GetMapping
    public CommonResponse get(@RequestParam("status") int status) {
        return CommonResponse.success(traceService.getByStatus(status));
    }

    @PostMapping
    public CommonResponse create(@RequestBody TraceParams traceParams) {
        traceService.create(traceParams);
        return CommonResponse.success();
    }
}
