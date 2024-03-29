package info.jiaying.back_end.api.file;

import com.google.common.primitives.Bytes;
import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.service.FileService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/file")
public class FileController {
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public CommonResponse upload(@RequestParam("file") MultipartFile file) throws IOException {
        return CommonResponse.success(fileService.save(file));
    }

    @PostMapping
    public CommonResponse uploadBytes(@RequestBody byte[] bytes) {
        return CommonResponse.success(fileService.save(bytes));
    }

    @GetMapping
    public CommonResponse get(@RequestParam("fileName") String fileName) {
        return CommonResponse.success(fileService.get(fileName));
    }
}
