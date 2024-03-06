package info.jiaying.back_end.model;

import lombok.Getter;

@Getter
public enum MessageType {
    TAIL(2),
    HEAD(0),
    NODE(1);

    private final int code;

    MessageType(int code) {
        this.code = code;
    }
}
