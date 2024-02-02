package info.jiaying.back_end.dto;

import lombok.Data;

@Data
public class UserLoginParams {
    private String username;
    private String password;
}
