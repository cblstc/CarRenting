package com.zuche.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zuche.entity.AdminUser;
import com.zuche.entity.StoreUser;
import com.zuche.entity.User;

public class StoreUserLoginInterceptor implements HandlerInterceptor {
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String url = request.getRequestURI();
		if(url.indexOf("store/toLogin")>=0 || url.indexOf("store/toRegist")>=0 ||
				url.indexOf("store/login")>=0 || url.indexOf("store/regist")>=0){   
			// 如果是登录、注册页面或登录、注册请求都放行
            return true;  
        }  
		//获取Session  
        HttpSession session = request.getSession();  
        
        StoreUser storeUser = (StoreUser) session.getAttribute("storeUser");
        if (storeUser != null ) {
        	return true;
        }
        //不符合条件的，跳转到登录界面  
        request.setAttribute("preLogin", "请先登录！");
        request.getRequestDispatcher("/store/toLogin").forward(request, response); 
        return false;
	}
}
