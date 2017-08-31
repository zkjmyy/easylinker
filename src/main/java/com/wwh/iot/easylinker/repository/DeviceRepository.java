package com.wwh.iot.easylinker.repository;

import com.wwh.iot.easylinker.entity.AppUser;
import com.wwh.iot.easylinker.entity.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by wwhai on 2017/8/1.
 */
public interface DeviceRepository extends JpaRepository<Device, String> {
    Page<Device> findByAppUser(AppUser user, Pageable pageable);

    Device findByConnectionId(String connectionId);

    Integer countByAppUser(AppUser appUser);

    @Query("select count(d.id) from Device  d where d.isOnline=1")
    int getOnlineDeviceCount();

}
