package info.jiaying.enums;

public enum EventType {
    onBoot(0),
    onError(1),
    onExecute(2),
    onFinish(3),
    onStop(4),
    onObtain(5);
    private int code;

    private EventType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
