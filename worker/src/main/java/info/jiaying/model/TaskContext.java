package info.jiaying.model;

import info.jiaying.utils.clazz.ClassUtils;
import lombok.Builder;
import lombok.Data;

@Data
public class TaskContext {
    private Object[] params;
    private Class<?>[] clazz;
    private String nextStage;

    public static TaskContext TASK_END = create(null);
    TaskContext(String nextStage, Object[] params, Class<?>[] clazz) {
        this.nextStage = nextStage;
        this.params = params;
        this.clazz = clazz;
    }

    public static TaskContext create(String nextStage, Object[] params) {
        if (params == null || params.length == 0) {
            return new TaskContext(nextStage, new Object[]{}, new Class<?>[]{});
        }
        return new TaskContext(nextStage, params, ClassUtils.resolve(params));
    }

    public static TaskContext create(String nextStage) {
        return create(nextStage, null);
    }
}
