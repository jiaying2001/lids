package info.jiaying.back_end.dto;

import lombok.Data;

@Data
public class CommonResponse<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResponse() {
    }

    protected CommonResponse(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResponse<T> success() {
        return new CommonResponse(1, "success", null);
    }

    public static <T> CommonResponse<T> success(T date) {
        return new CommonResponse<T>(1, "success", date);
    }
}
