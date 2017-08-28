package com.wwh.iot.easylinker.configure.activemq;

import com.wwh.iot.easylinker.constants.DeviceType;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * Created by wwhai on 2017/7/31.
 */

@Service("ActiveMQMessageProducer")
public class ActiveMQMessageProducer {

    @Autowired
    private JmsTemplate jmsTemplate;
    ActiveMQTopic activeMQTopic=new ActiveMQTopic("TEST");


    //@Scheduled(fixedDelay = 3000)//每3s执行1次
    public void testSend() {
        this.jmsTemplate.convertAndSend(activeMQTopic, "测试消息");
    }

    public void pushMessage(String deviceId, DeviceType deviceType, String message) {
        System.out.println(deviceType.toString() + "." + deviceId + message);

        this.jmsTemplate.convertAndSend(new ActiveMQTopic(deviceType.toString() + "." + deviceId), message);
    }
}
