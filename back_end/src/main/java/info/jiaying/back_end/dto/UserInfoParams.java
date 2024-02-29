package info.jiaying.back_end.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoParams {
    private String firstName;

    private String lastName;

    private String avatar;

    private String job;

    private String organization;

    private String email;

    private String introduction;

    private String personalWebsite;

    private String phone;
}
