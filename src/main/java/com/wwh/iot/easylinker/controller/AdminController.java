package com.wwh.iot.easylinker.controller;

import com.wwh.iot.easylinker.constants.DeviceType;
import com.wwh.iot.easylinker.constants.SystemMessage;
import com.wwh.iot.easylinker.entity.AppUser;
import com.wwh.iot.easylinker.entity.Device;
import com.wwh.iot.easylinker.respository.DeviceRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wwhai on 2017/7/30.
 */

/**
 * 管理员后台控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    DeviceRespository deviceRespository;//todo 单词拼错


    @RequestMapping("/")
    public String index() {
        return "/admin/index";
    }

    @RequestMapping("/devices")
    public String devices() {
        return "/admin/devices";
    }

    @RequestMapping("/addDevice")
    public String addDevice() {
        return "/admin/addDevice";
    }

    @RequestMapping("/add")
    public String add(Model model,HttpServletRequest httpServletRequest, @RequestParam String name, @RequestParam DeviceType type, @RequestParam String describe) {
        AppUser user = (AppUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Device device = new Device();

        device.setAppUser(user);
        device.setName(name);
        device.setDeviceDescribe(describe);
        device.setType(type);
        deviceRespository.save(device);
        model.addAttribute("message", SystemMessage.OPERATE_SUCCESS.toString());
        return "/admin/addDevice";
    }


    @RequestMapping("/sysConfig")
    public String sysConfig() {
        return "/admin/sysConfig";
    }

    @RequestMapping("/deviceDetail")
    public String deviceDetail(@RequestParam String deviceId) {
        return "/admin/deviceDetail";
    }


}
