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
    Logger logger= LoggerFactory.getLogger(AdviseConsumer.class);
    @Autowired
    DeviceRepository deviceRepository;

    @JmsListener(destination = "ActiveMQ.Advisory.Connection.>")

    public void receiveMessage(ActiveMQMessage connectionMessage) throws Exception {
        DataStructure dataStructure = connectionMessage.getDataStructure();

        if (dataStructure instanceof ConnectionInfo) {
            String connectionId = ((ConnectionInfo) dataStructure).getConnectionId().toString();
            System.out.println(connectionId);
            Device device=deviceRepository.findOne(((ConnectionInfo) dataStructure).getClientId());
            device.setConnectionId(connectionId);
            device.setIsOnline(true);
            deviceRepository.save(device);
            logger.info("device connected with id:"+connectionId);
            System.out.println("设备上线:" + connectionId);
        } else if (dataStructure instanceof RemoveInfo) {
            String objectId = ((RemoveInfo) dataStructure).getObjectId().toString();
            System.out.println("设备掉线:" + objectId);
            logger.info("device connected with id:"+objectId);
            Device device=deviceRepository.findByConnectionId(objectId);
            device.setIsOnline(false);
            deviceRepository.save(device);
        }
    }

}
