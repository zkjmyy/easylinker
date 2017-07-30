package com.wwh.iot.easylinker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wwhai on 2017/7/30.
 */

/**
 * 管理员后台控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/")
    public String index(){
        return "/admin/index";
    }

    @RequestMapping("/devices")
    public String devices(){
        return "/admin/devices";
    }

    @RequestMapping("/addDevice")
    public String addDevice(){
        return "/admin/addDevice";
    }

    @RequestMapping("/sysConfig")
    public String sysConfig(){
        return "/admin/sysConfig";
    }




}
