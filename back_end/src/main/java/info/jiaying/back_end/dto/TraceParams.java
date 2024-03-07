package info.jiaying.back_end.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TraceParams {
    @JsonProperty("trace_uuid")
    private String traceUuid;
    private String path;
    @JsonProperty("app_name")
    private String appName;
    private int score;
    private int status;
}
