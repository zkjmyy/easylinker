package com.wwh.iot.easylinker.activemqplugin;

import org.apache.activemq.broker.Broker;
import org.apache.activemq.broker.ConnectionContext;
import org.apache.activemq.command.ConnectionInfo;
import org.apache.activemq.security.AbstractAuthenticationBroker;
import org.apache.activemq.security.SecurityContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.cert.X509Certificate;

/**
 * Created by wwhai on 2017/9/1.
 */
public class AuthBroker extends AbstractAuthenticationBroker {
    private static Logger logger = LoggerFactory.getLogger(AuthBroker.class);

    public AuthBroker(Broker next) {
        super(next);
    }

    @Override
    public SecurityContext authenticate(String username, String password, X509Certificate[] peerCertificates) throws SecurityException {
        //SecurityContext securityContext = null;

        return null;

    }

    @Override
    public void addConnection(ConnectionContext context, ConnectionInfo connectionInfo) throws Exception {
        SecurityContext securityContext = context.getSecurityContext();
        String clientId = connectionInfo.getClientId().toString();
        logger.info(clientId);
        if (clientId!=null){
            logger.info("Success!");
        }else {
            logger.info("Failed!");
        }


    }
}
