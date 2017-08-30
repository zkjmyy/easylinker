package com.wwh.iot.easylinker.configure.activemq.consumer;

import com.wwh.iot.easylinker.entity.Device;
import com.wwh.iot.easylinker.repository.DeviceRepository;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ConnectionInfo;
import org.apache.activemq.command.DataStructure;
import org.apache.activemq.command.RemoveInfo;
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

    @JmsListener(destination = "ActiveMQ.Advisory.Connection.>")

    public void receiveMessage(ActiveMQMessage connectionMessage) throws Exception {
        DataStructure dataStructure = connectionMessage.getDataStructure();

        if (dataStructure instanceof ConnectionInfo) {
            String connectionId = ((ConnectionInfo) dataStructure).getConnectionId().toString();
            String clientId = (((ConnectionInfo) dataStructure).getClientId());
            //clientId :这个其实是设置的设备唯一标识Id
            if (clientId != null) {
                Device device = deviceRepository.findOne(clientId);
                if (device != null) {
                    device.setConnectionId(connectionId);
                    device.setIsOnline(true);
                    deviceRepository.save(device);
                    logger.info("device connected with id:" + connectionId);
                } else {
                    logger.info("device not exist!");

                }

            } else {
                logger.error("someone want to connect without ID!");
            }

        } else if (dataStructure instanceof RemoveInfo) {
            String objectId = ((RemoveInfo) dataStructure).getObjectId().toString();
            if (objectId != null) {

                Device device = deviceRepository.findByConnectionId(objectId);
                if (device != null) {
                    device.setIsOnline(false);
                    deviceRepository.save(device);
                    logger.info("device disconnected with id:" + objectId);
                }
            } else {
                logger.info("device not exist!");
            }

        } else {
            logger.error("someone disconnect without ID!");
        }


    }
}
