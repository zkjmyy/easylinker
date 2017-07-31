package com.wwh.iot.easylinker.configure.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by wwhai on 2017/7/31.
 */
@Component("TypeMediaConsumer")
public class TypeMediaConsumer {
    @JmsListener(destination = "TYPE_MEDIA")
    public void receiveMessage(String text) {
        System.out.println("Consumer2收到的报文为:"+text);
    }
}
