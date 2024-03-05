package info.jiaying.back_end.service;

import info.jiaying.back_end.model.UserIds;

import java.util.List;

public interface UserIdsService {
    List<UserIds> getIdsIdList(String username);

    void grant(int userId, int idsId);

    void revoke(int userId, int idsId);
}
