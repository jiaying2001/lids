package info.jiaying.back_end.service.impl;

import info.jiaying.back_end.dto.UserInfoParams;
import info.jiaying.back_end.mapper.UserInfoMapper;
import info.jiaying.back_end.model.UserInfo;
import info.jiaying.back_end.model.UserInfoExample;
import info.jiaying.back_end.service.UserInfoService;
import info.jiaying.back_end.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserService userService;

    @Override
    public void add(UserInfoParams params) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(userInfo, params);
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void delete(UserInfoParams params) {

    }

    @Override
    public UserInfo get() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        int userId = userService.getUserIdByName(authentication.getName());
        UserInfoExample example = new UserInfoExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return userInfoMapper.selectByExample(example).get(0);
    }
}
