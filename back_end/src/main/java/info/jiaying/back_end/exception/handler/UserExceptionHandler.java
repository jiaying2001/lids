package info.jiaying.back_end.exception.handler;

import info.jiaying.back_end.dto.CommonResponse;
import info.jiaying.back_end.exception.PasswordNotMatchException;
import info.jiaying.back_end.exception.UsernameNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class UserExceptionHandler{
    @ExceptionHandler(UsernameNotExistException.class)
    public CommonResponse handleUserNotExistExceptionHandler(UsernameNotExistException e) {
        return CommonResponse.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public CommonResponse handlePasswordNotMatchException(PasswordNotMatchException e) {
        return CommonResponse.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse handleException(Exception e) {
        return CommonResponse.fail(100, e.getMessage());
    }
}
