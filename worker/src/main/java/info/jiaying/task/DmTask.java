package info.jiaying.task;

import info.jiaying.http.ServerImpl;
import info.jiaying.http.ServerInterface;
import info.jiaying.model.TaskContext;

public class DmTask {
    ServerInterface server = new ServerImpl();
    public TaskContext parse(String fileName) {
        server.loadFileByFilename(fileName);
        return null;
    }
    public TaskContext train(String fileName) {
        return null;
    }
    public TaskContext deploy(String fileName) {
        return null;
    }
}
