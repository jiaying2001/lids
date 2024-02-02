package info.jiaying.back_end.service.impl;

import info.jiaying.back_end.dao.UserDao;
import info.jiaying.back_end.dto.UserLoginParams;
import info.jiaying.back_end.dto.UserSignUpParams;
import info.jiaying.back_end.model.UserInfo;
import info.jiaying.back_end.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void register(UserSignUpParams userSignUpParams) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userSignUpParams, userInfo);
        userDao.addUser(userInfo);
    }

    @Override
    public boolean login(UserLoginParams userLoginParams) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userLoginParams, userInfo);
        UserInfo _userInfo = userDao.getUserByUsername(userInfo);
        return _userInfo.getPassword().equals(userInfo.getPassword());
    }

    @Override
    public UserInfo getUser(UserInfo userInfo) {
        return userDao.getUserByUsername(userInfo);
    }
}
