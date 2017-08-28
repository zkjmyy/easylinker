package com.wwh.iot.easylinker.apiv1;

import com.alibaba.fastjson.JSONObject;
import com.wwh.iot.easylinker.configure.activemq.ActiveMQMessageProducer;
import com.wwh.iot.easylinker.constants.DeviceType;
import com.wwh.iot.easylinker.constants.SystemMessage;
import org.hibernate.annotations.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wwhai on 2017/8/28.
 */
@RequestMapping("/apiv1")
@RestController
public class APIV1Controller {
    @Autowired
    ActiveMQMessageProducer activeMQMessageProducer;

    @RequestMapping("/test")
    public JSONObject test() {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("message","test ok!");
        jsonObject.put("state",1);
        return jsonObject;
    }

    @RequestMapping("/sendMessage")
    public JSONObject sendMessage(@RequestParam String deviceId, @RequestParam DeviceType deviceType, @RequestParam(defaultValue = "default") String message) {
        return MessageSender.pushMessage(deviceId, deviceType, message);

    }
}
