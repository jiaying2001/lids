package info.jiaying.back_end.dto;

import lombok.Data;

import java.util.HashMap;

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

    public static  CommonResponse success(String key, Object value) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, value);
        return new CommonResponse<>(200, "success", map);
    }
    public static <T> CommonResponse<T> fail(long code, String msg) {return new CommonResponse<>(code, msg, null);}
}
