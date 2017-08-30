package com.wwh.iot.easylinker.configure.security;

import com.alibaba.fastjson.JSONObject;
import com.wwh.iot.easylinker.constants.SystemMessage;
import com.wwh.iot.easylinker.entity.AppUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/7/28.
 */

/**
 * 登录成功后第一个处理
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    JSONObject jsonObject = new JSONObject();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        System.out.println("登陆成功");
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String loginType = request.getParameter("loginType");
        if (loginType != null) {
            request.getSession().setAttribute("loginType", loginType);
            request.getSession().setAttribute("currentUser", appUser);
        }
        switch ((String) request.getSession().getAttribute("loginType")) {
            case "WEB":
                httpServletResponse.sendRedirect("/admin/index");
                break;
            case "API":
                jsonObject.put("message", SystemMessage.LOGIN_SUCCESS.toString());
                jsonObject.put("data", appUser);
                jsonObject.put("state", 1);
                httpServletResponse.getWriter().write(jsonObject.toJSONString());
                break;
            default:
                httpServletResponse.sendRedirect("/loginPage");
                break;
        }
    }
}
