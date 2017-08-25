package com.wwh.iot.easylinker.configure;

import com.wwh.iot.easylinker.configure.activemq.ActiveMQMessageListener;
import com.wwh.iot.easylinker.configure.activemq.ActiveMQMessageListenerContainer;
import com.wwh.iot.easylinker.configure.activemq.ActiveMqTransportListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.activemq.transport.TransportListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.MessageListenerContainer;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Date;

/**
 * Created by wwhai on 2017/7/31.
 */
@Configuration
public class ActiveMQConfig {
    /**
     * ActiveMQ的工厂
     *
     * @return
     */
    @Value("${spring.activemq.broker-url}")
    String url;
    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "password",
                url);
        activeMQConnectionFactory.setTransportListener(addActiveMqTransportListener());
         return activeMQConnectionFactory;
    }


    @Bean
    public TransportListener addActiveMqTransportListener() {
        return new ActiveMqTransportListener();

    }

    @Bean
    public ActiveMQMessageListener addActiveMQMessageListener() {

        return new ActiveMQMessageListener();
    }

    @Bean
    public MessageListenerContainer addActiveMQMessageListenerContainer(){
        return new ActiveMQMessageListenerContainer(activeMQConnectionFactory());
    }

}
