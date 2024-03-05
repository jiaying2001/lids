package info.jiaying.message;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

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
}
