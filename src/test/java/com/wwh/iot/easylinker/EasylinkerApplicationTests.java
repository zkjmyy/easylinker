package com.wwh.iot.easylinker;

import com.wwh.iot.easylinker.entity.Device;
import com.wwh.iot.easylinker.repository.DeviceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EasylinkerApplicationTests {
    @Autowired
    DeviceRepository deviceRepository;

    @Test
    public void test() {
        Device device = deviceRepository.findByConnectionId("ID:-54430-1503892726820-3:17");
        System.out.println(device);
    }

}
