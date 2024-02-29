package info.jiaying.back_end.api.user;

import info.jiaying.back_end.dao.HarvesterDao;
import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.dto.HarvesterParams;
import info.jiaying.back_end.service.HarvesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/api/harvester")
public class HarvesterController {
    @Autowired
    HarvesterService harvesterService;
    @PostMapping
    public CommonResponse create(@RequestBody HarvesterParams params) throws InvocationTargetException, IllegalAccessException {
        return harvesterService.create(params);
    }

    @PostMapping("/update/offset")
    public CommonResponse updateOffset(@RequestBody HarvesterParams params) {
        return harvesterService.updateOffsetByUserIdAndPath(params);
    }

    @PostMapping("/delete")
    public CommonResponse delete(@RequestBody HarvesterParams params) throws InvocationTargetException, IllegalAccessException {
        harvesterService.deleteByPath(params);
        return CommonResponse.success();
    }

    @GetMapping
    public CommonResponse get() {
        return CommonResponse.success(harvesterService.get());
    }
}
