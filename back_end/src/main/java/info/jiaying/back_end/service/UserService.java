package info.jiaying.back_end.service;

import info.jiaying.back_end.dto.UserLoginParams;
import info.jiaying.back_end.dto.UserSignUpParams;
import info.jiaying.back_end.model.UserInfo;

public interface UserService {

    void register(UserSignUpParams user);

    boolean login(UserLoginParams user);

    UserInfo getUser(UserInfo userInfo);
}
