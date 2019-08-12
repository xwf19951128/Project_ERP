package com.cskaoyan.interceptor;

import com.cskaoyan.bean.login.SysUser;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("js") || requestURI.endsWith("css")||requestURI.endsWith("png")||requestURI.endsWith("jpg")) {
            return true;
        }
        if (requestURI.contains("ajaxLogin")) {
            return true;
        }
        SysUser activeUser = (SysUser) request.getSession().getAttribute("activeUser");
        if (activeUser == null) {
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        }
        return true;
    }
}
