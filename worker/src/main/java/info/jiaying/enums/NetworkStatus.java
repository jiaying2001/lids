package info.jiaying.enums;

import lombok.Getter;

@Getter
public enum NetworkStatus {
    OK(200);

    private final int code;
    NetworkStatus(int code) {
        this.code = code;
    }
}
