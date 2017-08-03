package com.wwh.iot.easylinker.entity;

import com.wwh.iot.easylinker.constants.DeviceType;

import javax.persistence.*;
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
    @ManyToOne(cascade = CascadeType.ALL,optional = true)
    private AppUser appUser;
    private Boolean isOnline=false;

    public Boolean getIsOnline() {
        return this.isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

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

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
