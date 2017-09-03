package com.wwh.iot.easylinker.configure.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by wwhai on 2017/9/3.
 */
@Component("DisconnectedConsumer")
public class DisconnectedConsumer  {
    @JmsListener(destination = "DISCONNECTED.>")
    public void receiveMessage(String text) {
        System.out.println("from DISCONNECTED message:"+text);
    }
}
