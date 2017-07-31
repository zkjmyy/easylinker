package com.wwh.iot.easylinker.respository;

import com.wwh.iot.easylinker.entity.data.TypeSwitcherData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wwhai on 2017/8/1.
 */
public interface SwitcherDataRespository extends JpaRepository<TypeSwitcherData,String> {
}
