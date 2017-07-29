package com.wwh.iot.easylinker.configure.security;

import com.alibaba.fastjson.JSONObject;
import com.wwh.iot.easylinker.constants.ErrorMessage;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;

/**
 * Created by Administrator on 2017/7/28.
 */

/**
 * 认证失败异常处理
 */
public class UserAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    public JSONObject resultJson = new JSONObject();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        UserDisabledFailure(request, response, exception);
    }

    public void UserDisabledFailure(HttpServletRequest request, HttpServletResponse response,
                                    AuthenticationException exception) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        if (exception instanceof UsernameNotFoundException){
            resultJson.put("message", ErrorMessage.NO_ACTIVE.toString());
        }else if (exception instanceof UsernameNotFoundException){
            resultJson.put("message", ErrorMessage.USER_NOT_EXIST.toString());
        }else if (exception instanceof BadCredentialsException){
            resultJson.put("message", ErrorMessage.CREDIT_FAILED.toString());
        }else if (exception instanceof LockedException){
            resultJson.put("message", ErrorMessage.USER_LOCKED.toString());
        }else if (exception instanceof AccountExpiredException){
            resultJson.put("message", ErrorMessage.EXPIRED.toString());
        }
        System.out.println(exception.getClass().toString());

        resultJson.put("state", 0);
        response.getWriter().write(resultJson.toJSONString());
    }

}
