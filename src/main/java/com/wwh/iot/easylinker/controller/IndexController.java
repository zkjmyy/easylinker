package com.wwh.iot.easylinker.controller;

import com.wwh.iot.easylinker.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * Created by wwhai on 2017/7/27.
 */

/**
 * 首页控制器
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    DeviceRepository deviceRepository;
    @RequestMapping("/")
    public String defaultPage() {
        return "index";
    }

    @RequestMapping("/index")
    public String index(Model model) {

        return "index";
    }

    @RequestMapping("/signupPage")
    public String signupPage() {
        return "admin/signupPage";
    }

    @RequestMapping("/loginPage")
    public String loginPage() {
        return "loginpage";
    }

    @RequestMapping("/document")
    public String document() {
        return "document";
    }

    @RequestMapping("/loginFailed")
    public String loginFailed() {
        return "loginfailed";
    }

}
