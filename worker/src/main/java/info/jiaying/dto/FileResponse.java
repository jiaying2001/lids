package info.jiaying.dto;

import lombok.Data;

@Data
public class FileResponse extends AbstractResponse{
    byte[] data;
}
