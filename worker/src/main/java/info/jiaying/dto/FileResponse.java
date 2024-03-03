package info.jiaying.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileResponse extends AbstractResponse{
    byte[] data;
}
