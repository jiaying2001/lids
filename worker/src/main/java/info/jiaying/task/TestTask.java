package info.jiaying.task;

import info.jiaying.model.TaskContext;

public class TestTask {
    public TaskContext stage1 () {
        System.out.println("Executing stage one logic..");
        return TaskContext.builder()
            .nextStage("stage2")
            .params(new Object[] {
                    "msg from stage one"
            })
            .clazz(new Class[] {
                    String.class
            })
            .build();
    }

    public TaskContext stage2 (String msg) {
        System.out.println("Executing stage two logic..");
        System.out.println("Received msg " + msg);
        return TaskContext.builder()
                .nextStage("stage3")
                .params(new Object[] {
                        "msg from stage two"
                })
                .clazz(new Class[] {
                        String.class
                })
                .build();
    }

    public TaskContext stage3 (String msg) {
        System.out.println("Executing stage three logic..");
        System.out.println("Received msg " + msg);
        return TaskContext.builder()
                .build();
    }
}
