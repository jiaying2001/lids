package info.jiaying.back_end.model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class TrackHeadNodeLog extends CommonNodeLog {
    private String log;
}
