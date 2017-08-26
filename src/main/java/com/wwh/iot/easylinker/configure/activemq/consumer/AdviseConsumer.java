package com.wwh.iot.easylinker.configure.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by wwhai on 2017/8/26.
 */
@Component
public class AdviseConsumer {
    @JmsListener(destination = "ActiveMQ.Advisory.>")
    public void receiveMessage(String text) {

        System.out.println("Msg:"+text);
    }
}
