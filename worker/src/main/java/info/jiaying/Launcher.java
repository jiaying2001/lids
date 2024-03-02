package info.jiaying;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONReader;
import info.jiaying.config.LauncherConfig;
import info.jiaying.core.ObserverManager;
import info.jiaying.core.observers.TimeObserver;
import info.jiaying.enums.EventType;
import info.jiaying.http.ServerImpl;
import info.jiaying.http.ServerInterface;
import info.jiaying.model.Task;
import info.jiaying.model.TaskContext;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

/**
 * Hello world!
 *
 */
@Slf4j
public class Launcher
{
    private final String TASK_PACKAGE_NAME = "info.jiaying.task";
    ServerInterface server = new ServerImpl();
    ObserverManager observerManager = new ObserverManager(); // Event dispatcher

    LauncherConfig launcherConfig = new LauncherConfig();

    ThreadPoolExecutor executor;

    public Launcher() {
        executor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(launcherConfig.WAITING_QUEUE_SIZE));
        observerManager.registerEventObserver(new TimeObserver());
    }

    public void run () {
        for (;;) {
            if (launcherConfig.WAITING_QUEUE_SIZE - executor.getQueue().size() > launcherConfig.PULL_LIMIT) {
                // Pull tasks given task type from server
                List<Task> tasks = pullTasks();
                execute(tasks);
            }
            try {
                Thread.sleep(1000 + (int)(Math.random() * 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void execute(List<Task> tasks) {
        if (tasks.isEmpty()) {
            log.info("Pulled zero tasks");
            return;
        }

        log.info("Pulled " + tasks.size() + " tasks");

        for (Task task: tasks) {
            executor.submit(() -> doExecute(task));
        }

        log.info("Submitted all pulled tasks");
    }

    public void doExecute(Task task) {
        try {
            observerManager.wakeupObserver(EventType.onExecute, task);
            Class<?> clazz = Class.forName(TASK_PACKAGE_NAME + "." + task.getTaskType()); // Get class object of the task type
            TaskContext tc = JSONObject.parseObject(task.getTaskContext(), TaskContext.class, JSONReader.Feature.SupportClassForName);
            Method method = getMethodFromNameAndParameters(clazz, tc);
            TaskContext rtc = (TaskContext) method.invoke(clazz.getConstructor().newInstance(), tc.getParams());
            observerManager.wakeupObserver(EventType.onFinish, task, rtc);
        } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    private Method getMethodFromNameAndParameters(Class<?> task,TaskContext tc) {
        for (Method method: task.getMethods()) {
            if (method.getName().equals(tc.getNextStage()) && method.getParameterTypes().length == tc.getClazz().length && tc.getParams().length == method.getParameterCount()) {
                return method;
            }
        }
        throw new RuntimeException("Can not find the method for task " + task.getName());
    }

    public List<Task> pullTasks() {
        List<Task> tasks = doPullTasks();
        return tasks;
    }

    public List<Task> doPullTasks() {
        return server.getTaskList(launcherConfig.Task_TYPE.getSimpleName(), 0, launcherConfig.PULL_LIMIT);
    }
    public static void main( String[] args )
    {
        Launcher l = new Launcher();
        l.run();
    }
}
