package info.jiaying.back_end.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PasswordNotMatchException extends RuntimeException{
    private long code = 101;
    private static final PasswordNotMatchException DEFAULT = new PasswordNotMatchException(101, "Password does not match");

    public PasswordNotMatchException(long code, String message) {
        super(message);
        this.code = code;
    }


    public static PasswordNotMatchException getInstance() {
        return DEFAULT;
    }
}
