package info.jiaying.log_transfer_hub.message;

import lombok.Data;

import java.util.List;

@Data
public class LogMessage {
    private Header header;
    private Body body;
    private Property property;

    @Data
    public static class Header{
        private String traceId;
        private int userId;
        private String authToken;
        private String os;
        private String appName;
        private int pid;
        private String type;
        private FeatureExtraction fe;
        // Name convention: os_appName_type
        private String topic;
        private int count;
    }

    public enum FeatureExtraction {
        TRANSACTION
    }
    @Data
    public static class Body {
        private String content;
    }

    @Data
    public static class Property {
        private List<Long> startTimestamp;
        private List<Long> endTimestamp;
    }

}
