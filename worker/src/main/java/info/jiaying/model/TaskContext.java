package info.jiaying.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskContext {
    private Object[] params;
    private Class<?>[] clazz;
    private String nextStage;
}
