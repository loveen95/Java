package com.zerock.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BoardInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id==null) {
			response.sendRedirect("/MyWeb/member/login"); //해당 값을 가지고 되돌리기
			return false; //의미는 로그인을 못했다는 의미로 핸들러 메서드를 실행한 후에 컨트롤러를 수행하지 않음 
		}else {
			return true; //의미는 핸들러 메서드를 실행한 후 컨트롤러로 이동 하겠다는 의미이다.
		}
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		super.afterCompletion(request, response, handler, ex);
	}
	

}
