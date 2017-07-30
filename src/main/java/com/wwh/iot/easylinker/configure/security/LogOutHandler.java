package com.wwh.iot.easylinker.configure.security;

import com.alibaba.fastjson.JSONObject;
import com.wwh.iot.easylinker.constants.ErrorMessage;
import com.wwh.iot.easylinker.entity.AppUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/28.
 */
public class LogOutHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse httpServletResponse, Authentication arg2)
            throws IOException, ServletException {
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String loginType = (String) request.getSession().getAttribute("loginType");
        JSONObject jsonObject = new JSONObject();

        switch (loginType) {
            case "WEB":
                httpServletResponse.sendRedirect("/loginPage");
                break;
            case "API":
                jsonObject.put("message", ErrorMessage.LOGOUT_SUCCESS.toString());
                jsonObject.put("state", 1);
                httpServletResponse.getWriter().write(jsonObject.toJSONString());
                break;
            default:
                httpServletResponse.sendRedirect("/loginPage");
                break;
        }
    }
}
