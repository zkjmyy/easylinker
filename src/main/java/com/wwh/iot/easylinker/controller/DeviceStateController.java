package com.wwh.iot.easylinker.controller;

/**
 * Created by wwhai on 2017/8/25.
 */

import com.alibaba.fastjson.JSONObject;
import com.wwh.iot.easylinker.constants.SystemMessage;
import com.wwh.iot.easylinker.entity.Device;
import com.wwh.iot.easylinker.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备状态控制器
 */
@RestController
@RequestMapping("/device")
public class DeviceStateController {
    JSONObject resultJson = new JSONObject();
    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping("/state")
    public JSONObject state(@RequestParam(defaultValue = "") String deviceId, @RequestParam(defaultValue = "OFFLINE") String state) {
        Device device = deviceRepository.findOne(deviceId);
        switch (state) {
            case "OFFLINE":
                device.setIsOnline(false);
                break;
            case "ONLINE":
                device.setIsOnline(true);
                break;
            default:break;
        }

        deviceRepository.save(device);
        resultJson.put("message", SystemMessage.OPERATE_SUCCESS.toString());
        resultJson.put("state", 1);
        return resultJson;
    }
}
