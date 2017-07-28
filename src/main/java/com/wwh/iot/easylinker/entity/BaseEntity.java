package com.wwh.iot.easylinker.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/7/27.
 */

/**
 * JPA基类
 */
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "assignedGenerator")
    @GenericGenerator(name = "assignedGenerator", strategy = "assigned")
    private String id = UUID.randomUUID().toString();
    private Integer isDelete = 0;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createTime = new Date();
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getIsDelete() {
        return isDelete;
    }
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
