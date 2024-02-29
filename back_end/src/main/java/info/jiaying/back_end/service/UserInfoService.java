package info.jiaying.back_end.service;

import info.jiaying.back_end.dto.UserInfoParams;
import info.jiaying.back_end.model.UserInfo;

public interface UserInfoService {
    void add(UserInfoParams params);
    void delete(UserInfoParams params);
    UserInfo get();
}
