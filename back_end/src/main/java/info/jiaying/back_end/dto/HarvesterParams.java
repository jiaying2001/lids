package info.jiaying.back_end.dto;

import lombok.Data;

@Data
public class HarvesterParams {
    private int id;
    private int user_id;
    private int offset;
    private String path;
    private String file_format;
}
