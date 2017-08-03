package com.wwh.iot.easylinker.controller;

import com.alibaba.fastjson.JSONObject;
import com.wwh.iot.easylinker.constants.SystemMessage;
import com.wwh.iot.easylinker.entity.AppUser;
import com.wwh.iot.easylinker.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wwhai on 2017/7/27.
 */

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {
    JSONObject resultJson = new JSONObject();

    @Autowired
    AppUserRepository appUserRepository;

    @PostMapping("/signup")
    public String signup(HttpServletRequest httpServletRequest, @RequestParam String username, @RequestParam String email, @RequestParam String phone, @RequestParam String password) {
        AppUser appUser = new AppUser();
        appUser.setUsername(username);
        appUser.setEmail(email);
        appUser.setPhone(phone);
        appUser.setPassword(password);
        appUserRepository.save(appUser);
        httpServletRequest.getSession().setAttribute("message", SystemMessage.REGISTER_SUCCESS.toString());
        return "redirect:/loginPage";
    }

    @RequestMapping("/updatePage")
    public String updatePage() {
        return "admin/updatePage";

    }

    @RequestMapping("/update")
    public String update(@RequestParam String email, String phone, String password) {
        AppUser currentUser = (AppUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        currentUser.setEmail(email);
        currentUser.setPhone(phone);
        currentUser.setPassword(password);
        appUserRepository.save(currentUser);
        return "admin/updatePage";
    }
}
