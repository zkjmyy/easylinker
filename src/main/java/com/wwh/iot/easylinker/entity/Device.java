package com.wwh.iot.easylinker.entity;

import com.wwh.iot.easylinker.constants.DeviceType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

/**
 * Created by wwhai on 2017/7/31.
 */

/**
 * 设备
 */
@Entity
public class Device extends BaseEntity {
    private String name;
    @Enumerated(EnumType.STRING)
    private DeviceType type;
    private String serialNumber = UUID.randomUUID().toString();
    private String deviceDescribe;
    private String userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDeviceDescribe() {
        return deviceDescribe;
    }

    public void setDeviceDescribe(String deviceDescribe) {
        this.deviceDescribe = deviceDescribe;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
