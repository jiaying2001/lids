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
        return new CommonResponse(200, "success", null);
    }

    public static <T> CommonResponse<T> success(T date) {
        return new CommonResponse<T>(200, "success", date);
    }

    public static <T> CommonResponse<T> fail(long code, String msg) {return new CommonResponse<>(code, msg, null);}
}
