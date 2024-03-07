package info.jiaying.log_transfer_hub.message;

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
