package com.tomato.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 登录拦截器
*登录检查
* */
public class LoginHandlerIntercep implements HandlerInterceptor{

    //目标方法执行之前
    //preHandle方法获取当前执行的目标方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user == null){
            //未登录，返回登录页面
            //getRequestDispatcher:请求获取转发器
//            request.setAttribute(“curruser”,curruser)这个方法是将curruser这个对象保存在request作用域中，然后在转发进入的页面就可以获取到你的值
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/login.html").forward(request,response);
            return false;
        }else {
            //已登陆，放行
            return true;
        }

    }

}
