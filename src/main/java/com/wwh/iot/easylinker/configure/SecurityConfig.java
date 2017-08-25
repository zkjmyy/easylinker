package com.wwh.iot.easylinker.configure;

/**
 * Created by wwhai on 2017/7/27.
 */

import com.wwh.iot.easylinker.configure.security.*;
import com.wwh.iot.easylinker.service.AppUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全机制配置入口
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    AppUserDetailService appUserDetailService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/user/login/", "/logOut", "/v2/api-docs","/device/*", "/loginPage", "/static/**", "/js/**", "/css/**", "/images/**", "/assets/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(  "/user/signup","/document","/index","/signupPage","/loginFailed").permitAll();
        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin().loginPage("/user/login")
                .successHandler(new LoginSuccessHandler())
                .failureHandler(new LoginFailedHandler())
                .usernameParameter("loginpara").passwordParameter("password")
                .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .permitAll()
                .and().rememberMe()
                .and().exceptionHandling()
                .authenticationEntryPoint(new DefaultAuthenticationEntry())
                .and().csrf().disable();
    }

    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailService);
    }

    /**
     * 自定义UserDetailsService，从数据库中读取用户信息
     *
     * @return
     */
    @Bean
    public AppUserDetailService customUserDetailsService() {
        return new AppUserDetailService();
    }
}
