package org.anson.miniproduct.framework.springsecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration // 标识为配置类
@EnableWebSecurity// 启动Spring Security的安全管理
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService myUserDetailService;
    @Autowired
    private MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;
    @Autowired
    private MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.error("configure");
        // 若是前后端分离, csrf 必须关闭, 因为前端没带 csrf token
        http.csrf().disable();

        http
                .formLogin()
                // .loginPage("/pc/hasLogin") // 登录页面   // 前后端分离登录不再由后端控制
                .loginProcessingUrl("/login").permitAll() // 登录接口url, 无需登录即可访问
                .successHandler(myAuthenctiationSuccessHandler)
                .failureHandler(myAuthenctiationFailureHandler)
                // 配置所有请求都需要认证
                .and()
                .authorizeRequests()
                .anyRequest().authenticated(); //其他没有匹配到的路径都需要登录
    }
}
