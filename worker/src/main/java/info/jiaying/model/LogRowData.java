package info.jiaying.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class LogRowData {
    private String normalLog;
    private String abnormalLog;
}
