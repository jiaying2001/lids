package info.jiaying.back_end.dao;

import info.jiaying.back_end.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Insert("INSERT INTO user(username, password) VALUES(#{username}, #{password})")
    void addUser(UserInfo userInfo);

    @Select("SELECT * FROM user WHERE username = #{username}")
    UserInfo getUserByUsername(UserInfo userInfo);

}
