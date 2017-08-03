package com.wwh.iot.easylinker.controller;

import com.wwh.iot.easylinker.constants.DeviceType;
import com.wwh.iot.easylinker.constants.SystemMessage;
import com.wwh.iot.easylinker.entity.AppUser;
import com.wwh.iot.easylinker.entity.Device;
import com.wwh.iot.easylinker.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    DeviceRepository deviceRepository;


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
        Pageable pageable = new PageRequest(page, size, sort);
        //Page<Device>devicePage=deviceRepository.findAll()
        Page<Device>devicePage= deviceRepository.findByAppUser(user,new PageRequest(page, size, sort));
        model.put("devicePage",devicePage);
        return "/admin/devices";
    }


    @RequestMapping("/addDevice")
    public String addDevice() {
        return "/admin/addDevice";
    }

    @RequestMapping("/add")
    public String add(RedirectAttributes redirectAttributes, HttpServletRequest httpServletRequest, @RequestParam String name, @RequestParam DeviceType type, @RequestParam String describe) {
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
    public String deviceDetail(RedirectAttributes redirectAttributes,@RequestParam String deviceId) {
        redirectAttributes.addFlashAttribute("device",deviceRepository.findOne(deviceId));
        return "redirect:/admin/deviceDetail";
    }


}
