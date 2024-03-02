package info.jiaying.core.observers;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSONObject;
import info.jiaying.core.AnnType;
import info.jiaying.core.ObserverFunction;
import info.jiaying.dto.CommonResponse;
import info.jiaying.enums.EventType;
import info.jiaying.enums.TaskStatus;
import info.jiaying.http.ServerImpl;
import info.jiaying.http.ServerInterface;
import info.jiaying.model.Task;
import info.jiaying.model.TaskContext;
import lombok.extern.slf4j.Slf4j;

/**
 * 观察者
 */
@Slf4j
public class TimeObserver implements ObserverFunction {
    private String packageName;
    private Long beginTime;
    ServerInterface server = new ServerImpl();

    // 获取任务时改变任务状态
    @Override
    @AnnType(observerType = EventType.onObtain)
    public void onObtain() {
        System.out.println("开始加载上下文");
    }

    public Class<?> getaClass(String taskType) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(packageName + "." + taskType);
        return aClass;
    }


    // 执行任务前做的动作，目前是简单打印
    @Override
    @AnnType(observerType = EventType.onExecute)
    public void onExecute(Task task) {
        System.out.println("开始执行。");
    }

    // 启动动作
    @Override
    @AnnType(observerType = EventType.onBoot)
    public void onBoot() {
        System.out.println("--------------------------");
        System.out.println("控制台看到这个信息，证明你已经运行成功了~");
    }
    // 执行任务失败时的动作，目前是本地重试
    @Override
    @AnnType(observerType =EventType.onError)
    public void onError() {
        System.out.println("任务执行出错！");
    }
    // 任务执行完成做的动作
    @Override
    @AnnType(observerType = EventType.onFinish)
    public void onFinish(Task task, TaskContext taskContext){
        if (StrUtil.isNullOrUndefined(taskContext.getNextStage())) { // Detect reaching the end stage
            log.info("Task id " + task.getTaskId() + " done");
            task.setStatus(TaskStatus.SUCCESS.getStatus());
        } else {
            log.info("Task id " + task.getTaskId() + " succeeded in a stage");
            task.setStatus(TaskStatus.PENDING.getStatus());
            task.setTaskContext(JSONObject.toJSONString(taskContext));
        }
        server.setTask(task);
    }

    // 获取待定使用
    @Override
    @AnnType(observerType = EventType.onStop)
    public void onStop(){
    }
}
