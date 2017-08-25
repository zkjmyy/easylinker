package com.wwh.iot.easylinker.configure.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;

/**
 * MQ 异常监听器 <br>
 * Created by Lai Conghe on 2017-08-11
 */
public class ActiveMQExceptionListener implements ExceptionListener {

    Logger logger = LoggerFactory.getLogger( ActiveMQExceptionListener.class );

    @Override
    public void onException( JMSException e ) {
        logger.info("ActiveMQExceptionListener onException :" + e.getClass() );
    }
}
