package com.wwh.iot.easylinker.configure.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by wwhai on 2017/7/31.
 */
@Component("TypeValueConsumer")
public class TypeValueConsumer {
    @JmsListener(destination = "TYPE_VALUE")
    public void receiveMessage(String text) {
        System.out.println("from TYPE_VALUE message:"+text);
    }
}
