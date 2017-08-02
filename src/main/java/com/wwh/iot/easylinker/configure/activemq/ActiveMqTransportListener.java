package com.wwh.iot.easylinker.configure.activemq;

import org.apache.activemq.transport.TransportListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by wwhai on 2017/8/1.
 */
public class ActiveMqTransportListener implements TransportListener {
    private Logger logger = LoggerFactory.getLogger(ActiveMqTransportListener.class);

    @Override
    public void onCommand(Object o) {
        //logger.info("onCommand");
    }

    @Override
    public void onException(IOException e) {
        logger.info("onException");
    }

    @Override
    public void transportInterupted() {
        logger.info("transportInterupted");
    }

    @Override
    public void transportResumed() {
        logger.info("transportResumed");
    }
}
