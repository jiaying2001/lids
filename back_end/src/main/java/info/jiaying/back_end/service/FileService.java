package info.jiaying.back_end.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String save(MultipartFile file) throws IOException;
    byte[] get(String path);

    String save(byte[] bytes);
}
