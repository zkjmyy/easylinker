package com.wwh.iot.easylinker.activemqplugin;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerFilter;
import org.apache.activemq.broker.ProducerBrokerExchange;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.command.Message;

/**
 * Created by wwhai on 2017/9/1.
 */
public class AuthBroker extends BrokerFilter {

    public AuthBroker(Broker next) {
        super(next);
    }

    @Override
    public void send(ProducerBrokerExchange producerExchange, Message messageSend) throws Exception {
        ActiveMQTextMessage receivedMessage = (ActiveMQTextMessage) messageSend;
        String message = receivedMessage.getText();
        System.out.println("destnation:" + receivedMessage.getDestination());
        System.out.println("message:" + receivedMessage.getText());
        System.out.println(messageSend);


    }

}
