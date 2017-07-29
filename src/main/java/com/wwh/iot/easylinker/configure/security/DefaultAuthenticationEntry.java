package com.wwh.iot.easylinker.configure.security;

import com.alibaba.fastjson.JSONObject;
import com.wwh.iot.easylinker.constants.ErrorMessage;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/28.
 */

/**
 * 默认的访问路径
 */
public class DefaultAuthenticationEntry implements org.springframework.security.web.AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        httpServletRequest.getSession().setAttribute("loginfailedMsg", "登录失败");
        httpServletResponse.sendRedirect("/loginPage");
    }
}
