package com.wwh.iot.easylinker.controller;

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
    @RequestMapping("/")
    public String defaultPage() {
        return "index";
    }

    @RequestMapping("/index")
    public String index(ModelMap model) {
        Map<String, Object> systemInfo = new HashMap<>();
        Properties props = System.getProperties(); //获得系统属性集
        String osName = props.getProperty("os.name"); //操作系统名称
        String osArch = props.getProperty("os.arch"); //操作系统构架
        String osVersion = props.getProperty("os.version"); //操作系统版本
        String totalMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M";
        String freeMemory = Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M";
        String alreadyUse = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 / 1024 + "M";
        systemInfo.put("osName", osName);
        systemInfo.put("osArch", osArch);
        systemInfo.put("osVersion", osVersion);
        systemInfo.put("totalMemory", totalMemory);
        systemInfo.put("freeMemory", freeMemory);
        systemInfo.put("alreadyUse", alreadyUse);
        model.addAttribute(systemInfo);
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
