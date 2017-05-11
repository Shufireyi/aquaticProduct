package com.fire.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        // 获取请求的url
        String url = request.getRequestURI();
        // 判断url是否是登陆提交的地址
        if (url.indexOf("checklogin.action") >= 0) {
            // 如果进行登陆提交，放行
            return true;
        }

        if (url.indexOf("register.action") >= 0) {
            //如果是注册请求，放行
            return true;
        }

        // 判断session
        HttpSession session = request.getSession();
        // 从session中取出用户身份信息
        String nowUser = (String) session.getAttribute("nowUser");

        if (nowUser != null) {
            // 身份存在，放行
            return true;
        }

        // 执行这里表示用户身份需要认证，跳转登陆页面
        response.sendRedirect("/index.html");

        // return false表示拦截，不向下执行
        // return true表示放行
        return false;
    }


    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {


    }


    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {


    }
}
