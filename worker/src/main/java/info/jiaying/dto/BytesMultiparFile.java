package info.jiaying.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class BytesMultiparFile implements MultipartFile {
    private InputStream inputStream;

    public BytesMultiparFile(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public String getName() {
        return "null";
    }

    @Override
    public String getOriginalFilename() {
        return "null";
    }

    @Override
    public String getContentType() {
        return "type";
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return inputStream.readAllBytes();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return inputStream;
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {

    }
}
