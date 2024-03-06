package info.jiaying.back_end.service;

import info.jiaying.back_end.dto.UserSignUpParams;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    void register(UserSignUpParams user);

    String login(String username, String password);

    UserDetails getUser(String username);

    UserDetails loadUserByUsername(String username);

    int getUserIdByName(String username);
}
