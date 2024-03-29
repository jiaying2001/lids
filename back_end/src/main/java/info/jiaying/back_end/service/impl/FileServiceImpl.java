package info.jiaying.back_end.service.impl;

import cn.hutool.core.lang.UUID;
import info.jiaying.back_end.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.upload}")
    private String FILE_PATH;

    @Value("${file.suffix}")
    private String SUFFIX;

    @Override
    public String save(MultipartFile file) throws IOException {
        return save(file.getBytes());
    }

    @Override
    public byte[] get(String fileName){
        try (FileInputStream file = new FileInputStream(FILE_PATH + fileName + "." + SUFFIX)){
           return file.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String save(byte[] bytes) {
        String uuid = UUID.randomUUID().toString();
        try (FileOutputStream f = new FileOutputStream(FILE_PATH + uuid + "." + SUFFIX)) {
            f.write(bytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return uuid;
    }
}
