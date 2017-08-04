package com.wwh.iot.easylinker.configure.activemq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageListener;

/**
 * Created by wwhai on 2017/8/4.
 */
public class ActiveMQMessageListenerContainer extends SimpleMessageListenerContainer {


    public ActiveMQMessageListenerContainer(ConnectionFactory factory ) {
        setConnectionFactory(factory);
        setDestination(new ActiveMQTopic("TEST"));
        setMessageListener(new ActiveMQMessageListener());
    }
}
