package com.wwh.iot.easylinker.service;

import com.wwh.iot.easylinker.constants.ErrorMessage;
import com.wwh.iot.easylinker.entity.AppUser;
import com.wwh.iot.easylinker.respository.AppUserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/27.
 */

/**
 * 用户detail获取service
 */
public class AppUserDetailService implements UserDetailsService {
    @Autowired
    AppUserRespository appUserRespository;

    @Override
    public UserDetails loadUserByUsername(String parame) throws UsernameNotFoundException {
        /**
         * 可以用Username Or Email Or Phone 登录
         */
        AppUser appUser = appUserRespository.findTop1ByUsernameOrEmailOrPhone(parame, parame, parame);
        if (appUser == null) {
            throw new UsernameNotFoundException(ErrorMessage.USER_NOT_EXIST.toString());
        } else if (!appUser.isEnabled()) {
            throw new DisabledException(ErrorMessage.NO_ACTIVE.toString());
        } else if (!appUser.isAccountNonLocked()) {
            throw new LockedException(ErrorMessage.USER_LOCKED.toString());
        } else {
            return appUser;
        }
    }
}
