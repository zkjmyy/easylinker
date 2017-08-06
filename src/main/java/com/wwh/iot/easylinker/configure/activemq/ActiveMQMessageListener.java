package com.wwh.iot.easylinker.configure.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * Created by wwhai on 2017/7/31.
 */

/**
 * Mq消息监听器，传感器消息传入入口
 */
@Component
public class ActiveMQMessageListener implements MessageListener {
    Logger logger = LoggerFactory.getLogger(ActiveMQMessageListener.class);

    @Override
    public void onMessage(Message arg0) {
        TextMessage textMessage = (TextMessage) arg0;
        logger.info("onMessage :" + textMessage.toString());

    }


}
