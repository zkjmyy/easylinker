package com.wwh.iot.easylinker.repository;

import com.wwh.iot.easylinker.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wwhai on 2017/7/28.
 */

/**
 * 用户Dao
 */
public interface AppUserRepository extends JpaRepository<AppUser, String> {

    AppUser findTop1ByApiKey(String apiKey);
    AppUser findTop1ByUsernameOrEmailOrPhone(String parame1, String parame2, String parame3);


}