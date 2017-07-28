package com.wwh.iot.easylinker.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by wwhai on 2017/7/27.
 */

/**
 * API访问控制过滤器
 */
@WebFilter(servletNames = "ApiACLFilter")
public class ApiACLFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
