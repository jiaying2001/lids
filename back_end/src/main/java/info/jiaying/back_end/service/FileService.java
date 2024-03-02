package info.jiaying.back_end.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String save(MultipartFile file);
    byte[] get(String path);
}
