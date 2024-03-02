package info.jiaying.core;

import info.jiaying.enums.EventType;
import info.jiaying.model.Task;
import info.jiaying.model.TaskContext;

public interface ObserverFunction {
    // 执行任务前做的动作，目前是简单打印
    void onExecute(Task task);

    void onBoot();
    void onObtain();

    // 任务执行完成做的动作
    void onFinish(Task task, TaskContext taskContext);

    void onStop();
    void onError();
}
