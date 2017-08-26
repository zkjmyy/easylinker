package com.wwh.iot.easylinker.configure;

import com.wwh.iot.easylinker.configure.activemq.ActiveMQMessageListener;
import com.wwh.iot.easylinker.configure.activemq.ActiveMQMessageListenerContainer;
import com.wwh.iot.easylinker.configure.activemq.ActiveMqTransportListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.transport.TransportListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.MessageListenerContainer;

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
    public ActiveMQConnectionFactory activeMQConnectionFactory() throws Exception {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory("admin", "password",
                url);
        activeMQConnectionFactory.setTransportListener(addActiveMqTransportListener());
        activeMQConnectionFactory.setWatchTopicAdvisories(true);

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
    public MessageListenerContainer addActiveMQMessageListenerContainer() throws Exception {
        return new ActiveMQMessageListenerContainer(activeMQConnectionFactory());
    }
}
