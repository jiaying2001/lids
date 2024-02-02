package info.jiaying.back_end.config;

import info.jiaying.back_end.security.filter.JwtAuthenticationFilter;
import info.jiaying.back_end.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CommonSecurityConfig {
    @Autowired
    private UserService userService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(){
        return new JwtAuthenticationFilter();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return (username) -> userService.loadUserByUsername(username);
    }
}
