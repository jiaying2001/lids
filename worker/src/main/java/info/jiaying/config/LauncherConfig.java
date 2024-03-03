package info.jiaying.config;

import info.jiaying.task.DmTask;

import java.util.List;

public class LauncherConfig {
    public int PULL_LIMIT = 5; // The number of tasks to pull from server
    public int WAITING_QUEUE_SIZE = 100; // The size of wait queue
    public Class<?> Task_TYPE = DmTask.class; // The type of task the launcher does
}
