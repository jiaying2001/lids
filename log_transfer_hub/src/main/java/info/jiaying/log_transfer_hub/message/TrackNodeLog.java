package info.jiaying.log_transfer_hub.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class TrackNodeLog extends CommonNodeLog {
    private long end_time;
}
