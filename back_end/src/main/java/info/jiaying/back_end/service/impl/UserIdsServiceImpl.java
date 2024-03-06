package info.jiaying.back_end.service.impl;

import info.jiaying.back_end.mapper.UserIdsMapper;
import info.jiaying.back_end.model.UserIds;
import info.jiaying.back_end.model.UserIdsExample;
import info.jiaying.back_end.service.UserIdsService;
import info.jiaying.back_end.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserIdsServiceImpl implements UserIdsService {
    @Autowired
    UserIdsMapper userIdsMapper;
    @Autowired
    UserService userService;
    @Override
    public List<UserIds> getIdsIdList(String username) {
        UserIdsExample e =new UserIdsExample();
        e.createCriteria().andUserIdEqualTo(userService.getUserIdByName(username));
        return userIdsMapper.selectByExample(e);
    }

    @Override
    public void grant(int userId, int idsId) {
        UserIds userIds = new UserIds();
        userIds.setIdsId(idsId);
        userIds.setUserId(userId);
        userIdsMapper.insert(userIds);
    }

    @Override
    public void revoke(int userId, int idsId) {
        UserIdsExample e = new UserIdsExample();
        e.createCriteria().andUserIdEqualTo(userId).andIdsIdEqualTo(idsId);
        userIdsMapper.deleteByExample(e);
    }
}
