package com.wwh.iot.easylinker.filter;

import com.alibaba.fastjson.JSONObject;
import com.wwh.iot.easylinker.constants.SystemMessage;
import com.wwh.iot.easylinker.entity.AppUser;
import com.wwh.iot.easylinker.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wwhai on 2017/7/27.
 */

/**
 * API访问控制过滤器
 */
@WebFilter(servletNames = "ApiACLFilter", urlPatterns = "/apiv1/*")
public class ApiACLFilter implements Filter {
    JSONObject resultJson=new JSONObject();
    @Autowired
    AppUserRepository appUserRepository;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String apiKey=httpServletRequest.getHeader("APIKEY");
        if (apiKey != null&&appUserRepository.findTop1ByApiKey(apiKey)!=null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resultJson.put("state",0);
            resultJson.put("message", SystemMessage.REQUIRED_APIKEY.toString());
        }
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.getWriter().write(resultJson.toJSONString());
    }

    @Override
    public void destroy() {
        destroy();

    }
}
