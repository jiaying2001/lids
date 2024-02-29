package info.jiaying.back_end.model;


import lombok.Data;

@Data
public class HarvesterConf {
    private int id;
    private int user_id;
    private int offset;
    private String path;
    private String file_format;
}
