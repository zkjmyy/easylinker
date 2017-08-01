package com.wwh.iot.easylinker.configure.activemq;

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
public class ActiveMQMessageListener implements MessageListener {
    @Override
    public void onMessage(Message arg0) {
        TextMessage textMessage = (TextMessage) arg0;
        try {
            System.out.println("接收到的消息内容是：" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }



}
