package info.jiaying.back_end.service.impl;

import info.jiaying.back_end.dao.UserDao;
import info.jiaying.back_end.dto.UserSignUpParams;
import info.jiaying.back_end.exception.PasswordNotMatchException;
import info.jiaying.back_end.exception.UsernameNotExistException;
import info.jiaying.back_end.model.UserLogin;
import info.jiaying.back_end.service.UserService;
import info.jiaying.back_end.utils.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void register(UserSignUpParams userSignUpParams) {
        UserLogin userLogin = new UserLogin();
        BeanUtils.copyProperties(userSignUpParams, userLogin);
        userLogin.setPassword(passwordEncoder.encode(userLogin.getPassword()));
        userDao.addUser(userLogin);
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        //密码需要客户端加密后传递
            UserDetails userDetails = loadUserByUsername(username);
            if (userDetails == null) {
                throw UsernameNotExistException.getInstance();
            }
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw PasswordNotMatchException.getInstance();
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtUtil.generateToken(userDetails);
        return token;
    }

    @Override
    public UserDetails getUser(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public int getUserIdByName(String username) {
        return userDao.getUserIdByName(username);
    }

    @Override
    public int getUserId() {
        return getUserIdByName(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
