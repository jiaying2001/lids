package info.jiaying.log_transfer_hub.model;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Log {
    @JSONField(name = "@timestamp")
    Date processingTime;
    String message;
    String messageLen;
    String path;
    Date eventTime;
    int eventType = -1;
}
