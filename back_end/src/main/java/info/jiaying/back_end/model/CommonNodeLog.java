package info.jiaying.back_end.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CommonNodeLog {
    private String user_id;
    private String trace_id;
    private String node_name;
    private int count;
    private long create_time;
    private int type;
    private String path;
    private String app_name;
}
