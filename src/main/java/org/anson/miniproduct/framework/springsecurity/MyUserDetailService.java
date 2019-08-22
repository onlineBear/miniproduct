package org.anson.miniproduct.framework.springsecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (!"dev".equals(s)){
            log.info("登录失败");
            throw new UsernameNotFoundException("只有一个dev用户");
        }

        MyUserDetails user = new MyUserDetails("dev", "123456");
        log.info("登录成功");
        return user;
    }
}
