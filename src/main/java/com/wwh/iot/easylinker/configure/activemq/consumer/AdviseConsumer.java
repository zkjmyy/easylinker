package com.wwh.iot.easylinker.configure.activemq.consumer;

import com.wwh.iot.easylinker.entity.Device;
import com.wwh.iot.easylinker.repository.DeviceRepository;
import org.apache.activemq.command.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by wwhai on 2017/8/26.
 */

/**
 * 监听设备在线状态的
 */
@Component
public class AdviseConsumer {
    Logger logger = LoggerFactory.getLogger(AdviseConsumer.class);
    @Autowired
    DeviceRepository deviceRepository;
    boolean isLegalDevice = false;//默认没有连接

    @JmsListener(destination = "ActiveMQ.Advisory.Connection.>")
    public void onConnectionMessage(ActiveMQMessage connectionMessage) throws Exception {
        DataStructure dataStructure = connectionMessage.getDataStructure();
        if (dataStructure instanceof ConnectionInfo) {
            String connectionId = ((ConnectionInfo) dataStructure).getConnectionId().toString();
            String clientId = (((ConnectionInfo) dataStructure).getClientId());
            Device device = null;
            if (clientId != null && (device = deviceRepository.findOne(clientId)) != null) {
                    device.setConnectionId(connectionId);
                    device.setIsOnline(true);
                    deviceRepository.save(device);
                    isLegalDevice = true;
                    logger.info("Device connected with id:" + connectionId);
            } else {
                logger.warn("Illegal device want to connect without ID!");
            }

        } else if (dataStructure instanceof RemoveInfo && isLegalDevice) {
            String objectId = ((RemoveInfo) dataStructure).getObjectId().toString();
            Device device = deviceRepository.findByConnectionId(objectId);
            device.setIsOnline(false);
            deviceRepository.save(device);
            logger.info("Device disconnected with connection-id:" + objectId);
        } else {
            logger.warn("Illegal device disconnect without ID!");
        }


    }


}
