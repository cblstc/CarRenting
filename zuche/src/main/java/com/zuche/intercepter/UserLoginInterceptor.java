package com.zuche.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zuche.entity.AdminUser;
import com.zuche.entity.StoreUser;
import com.zuche.entity.User;

/**
 * 用户登录拦截器
 * @author cbl
 *
 */
public class UserLoginInterceptor implements HandlerInterceptor {

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
		if(url.indexOf("user/toLogin")>=0 || url.indexOf("user/toRegist")>=0 ||
				url.indexOf("user/login")>=0 || url.indexOf("user/regist")>=0){   
			// 如果是登录、注册页面或登录、注册请求都放行
            return true;  
        }  
		//获取Session  
        HttpSession session = request.getSession();  
        
    	User user = (User) session.getAttribute("user");
        if (user != null ) {
        	return true;
        }
        //不符合条件的，跳转到登录界面  
        request.getRequestDispatcher("/user/toLogin").forward(request, response);
        return false;
	}
}
