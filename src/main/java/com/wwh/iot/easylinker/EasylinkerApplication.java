package com.wwh.iot.easylinker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动入口
 */
@SpringBootApplication
@EnableWebSecurity
@EnableScheduling
@EnableWebMvc
@EnableSwagger2
@ServletComponentScan
@EnableJms
public class EasylinkerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasylinkerApplication.class, args);
    }
}
