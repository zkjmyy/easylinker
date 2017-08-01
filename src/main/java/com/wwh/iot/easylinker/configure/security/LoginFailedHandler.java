package com.wwh.iot.easylinker.configure.security;

import com.alibaba.fastjson.JSONObject;
import com.wwh.iot.easylinker.constants.SystemMessage;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/28.
 */

/**
 * 登录失败处理器
 */
public class LoginFailedHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        String loginType = httpServletRequest.getParameter("loginType");
        JSONObject jsonObject=new JSONObject();

        switch (loginType) {
            case "WEB":
                httpServletResponse.sendRedirect("/loginFailed");
                break;
            case "API":
                jsonObject.put("message", SystemMessage.LOGIN_FAILED.toString());
                jsonObject.put("state", 0);
                httpServletResponse.getWriter().write(jsonObject.toJSONString());
                break;
            default:
                break;
        }
    }
}
