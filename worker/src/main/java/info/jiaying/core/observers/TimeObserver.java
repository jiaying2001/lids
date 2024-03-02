package info.jiaying.core.observers;

import info.jiaying.core.AnnType;
import info.jiaying.core.ObserverFunction;
import info.jiaying.enums.EventType;
import info.jiaying.http.ServerImpl;
import info.jiaying.http.ServerInterface;
/**
 * 观察者
 */
public class TimeObserver implements ObserverFunction {
    private String packageName;
    private Long beginTime;
    ServerInterface taskFlower = new ServerImpl();

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
    public void onExecute() {
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
    public void onFinish(){
        System.out.println("执行完毕！");
    }

    // 获取待定使用
    @Override
    @AnnType(observerType = EventType.onStop)
    public void onStop(){
    }
}
