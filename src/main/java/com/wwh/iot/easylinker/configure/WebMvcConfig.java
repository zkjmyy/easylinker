package com.wwh.iot.easylinker.configure;

/**
 * Created by wwhai on 2017/7/27.
 */

import com.wwh.iot.easylinker.filter.ApiACLFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * SpringMVC配置入口
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
    }
    @Bean
    public FilterRegistrationBean ApiKeyFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new ApiACLFilter());
        registration.addUrlPatterns("/api/v1.0/*");
        return registration;
    }

}