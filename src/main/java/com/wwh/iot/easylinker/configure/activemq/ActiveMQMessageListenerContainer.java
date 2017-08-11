package com.wwh.iot.easylinker.configure.activemq;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import javax.jms.ConnectionFactory;

/**
 * Created by wwhai on 2017/8/4.   <br>
 * @update Lai Conghe on 2017-08-11
 */
public class ActiveMQMessageListenerContainer extends SimpleMessageListenerContainer {

    public ActiveMQMessageListenerContainer(ConnectionFactory factory ) {
        setConnectionFactory(factory);
        setDestination(new ActiveMQTopic("TEST"));
        setMessageListener(new ActiveMQMessageListener());
        setExceptionListener( new ActiveMQExceptionListener() );
    }
}
