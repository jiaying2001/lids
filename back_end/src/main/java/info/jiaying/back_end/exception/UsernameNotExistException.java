package info.jiaying.back_end.exception;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsernameNotExistException extends RuntimeException{
    private long code;
    private static final int ERROR_CODE = 100;
    private static final UsernameNotExistException DEFAULT = new UsernameNotExistException(100, "Username does not exist");

    public UsernameNotExistException(long code, String msg) {
        super(msg);
        this.code = code;
    }

    public static UsernameNotExistException fail(String msg) {
        return new UsernameNotExistException(ERROR_CODE, msg);
    }

    public static UsernameNotExistException getInstance() {return DEFAULT;}
}
