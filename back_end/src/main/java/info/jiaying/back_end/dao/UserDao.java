package info.jiaying.back_end.dao;

import info.jiaying.back_end.model.UserInfo;
import info.jiaying.back_end.model.UserLogin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDao {
    @Insert("INSERT INTO user(username, password) VALUES(#{username}, #{password})")
    void addUser(UserLogin userLogin);

    @Select("SELECT * FROM user WHERE username = #{username}")
    UserLogin getUserByUsername(String username);

    @Select("SELECT `id` FROM `user` WHERE `username` = #{username}")
    int getUserIdByName(String username);
}
