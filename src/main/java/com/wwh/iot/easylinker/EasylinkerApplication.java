package com.wwh.iot.easylinker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 启动入口
 */
@SpringBootApplication
@EnableWebMvc
@EnableWebSecurity
@EnableScheduling
@ServletComponentScan
public class EasylinkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasylinkerApplication.class, args);
    }
}
