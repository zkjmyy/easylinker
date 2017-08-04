package com.wwh.iot.easylinker.configure.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by wwhai on 2017/7/31.
 */
@Component("TypeSwitcherConsumer")
public class TypeSwitcherConsumer {
    @JmsListener(destination = "TYPE_SWITCHER")
    public void receiveMessage(String text) {
        System.out.println("from TYPE_SWITCHER message:"+text);
    }
}
