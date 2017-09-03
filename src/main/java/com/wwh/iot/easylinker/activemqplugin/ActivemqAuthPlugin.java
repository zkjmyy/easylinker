package com.wwh.iot.easylinker.activemqplugin;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.BrokerPlugin;


/**
 * Created by wwhai on 2017/9/1.
 */
public class ActivemqAuthPlugin implements BrokerPlugin {
    @Override
    public Broker installPlugin(Broker broker) throws Exception {
        return new AuthBroker(broker);
    }
}
