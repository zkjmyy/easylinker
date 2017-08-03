package com.wwh.iot.easylinker.controller;

import com.alibaba.fastjson.JSONObject;
import com.wwh.iot.easylinker.configure.activemq.ActiveMQMessageProducer;
import com.wwh.iot.easylinker.constants.DeviceType;
import com.wwh.iot.easylinker.constants.SystemMessage;
import com.wwh.iot.easylinker.entity.AppUser;
import com.wwh.iot.easylinker.entity.Device;
import com.wwh.iot.easylinker.repository.AppUserRepository;
import com.wwh.iot.easylinker.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;

/**
 * Created by wwhai on 2017/7/30.
 */

/**
 * 管理员后台控制器
 */
@Controller
@RequestMapping("/admin")
@Transactional
public class AdminController {
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    ActiveMQMessageProducer activeMQMessageProducer;


    @RequestMapping("/")
    public String index() {
        return "/admin/index";
    }

    @RequestMapping("/devices")
    public String devices(ModelMap model, @RequestParam(value = "page", defaultValue = "0") Integer page,
                          @RequestParam(value = "size", defaultValue = "15") Integer size) {
        AppUser user = (AppUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Sort sort = new Sort(Sort.Direction.DESC, "id");

        Page<Device> devicePage = deviceRepository.findByAppUser(user, new PageRequest(page, size, sort));
        System.out.println(devicePage.getNumberOfElements());
        model.put("devicePage", devicePage);
        return "/admin/devices";
    }


    @RequestMapping("/addDevice")
    public String addDevice() {
        return "/admin/addDevice";
    }

    @RequestMapping("/add")
    public String add(RedirectAttributes redirectAttributes, @RequestParam String name, @RequestParam DeviceType type, @RequestParam String describe) {
        AppUser user = (AppUser) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Device device = new Device();

        device.setAppUser(user);
        device.setName(name);
        device.setDeviceDescribe(describe);
        device.setType(type);
        deviceRepository.save(device);
        redirectAttributes.addFlashAttribute("message", SystemMessage.OPERATE_SUCCESS.toString());
        return "redirect:/admin/addDevice";
    }


    @RequestMapping("/sysConfig")
    public String sysConfig() {
        return "/admin/sysConfig";
    }

    @RequestMapping("/config")
    public String config() {
        return "/admin/sysConfig";
    }


    @RequestMapping("/deviceDetail")
    public String deviceDetail( ModelMap modelMap, @RequestParam String deviceId) {
        modelMap.put("device", deviceRepository.findOne(deviceId));
        return "/admin/deviceDetail";
    }


    @RequestMapping("/pushMessage")
    public JSONObject pushMessage( @RequestParam String deviceId,@RequestParam DeviceType deviceType, @RequestParam String message) {
        activeMQMessageProducer.pushMessage(deviceId,deviceType,message);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("state",1);
        jsonObject.put("message",SystemMessage.OPERATE_SUCCESS.toString());
        return  jsonObject;
    }


}
