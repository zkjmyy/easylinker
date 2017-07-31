package com.wwh.iot.easylinker.configure.activemq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
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

    @Scheduled(fixedDelay = 3000)//每3s执行1次
    public void send() {
        this.jmsTemplate.convertAndSend("TYPE_MEDIA", "TYPE_MEDIA");
        System.out.println("TYPE_MEDIA");
    }
}
