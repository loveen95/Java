package com.zerock.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
//1.스프링에서 제공하 는 HandlerIntercepterAdapter클래스를 상속
//2. alt + shift + s => overriding method를 통해서 3가지 메서드 오버라이딩 처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		if(user_id == null) {
			response.sendRedirect("/MyWeb/session/loginPage");
			return false; 
			
			//return false의 의미는 핸들러 메서드를 실행 한 후Controller를 수행하지 않음.
			
		}else {
			return true;
			//return true의 의미는핸들러 메서드를 실행후controller를 수행 
		}
		
	}
    //preHandle에서 true를 리턴하여 컨트롤러를 실행할 때만 동작합니다.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	//prehand()메서드는 컨트롤러을 실행하기 전 요청을 가로채서 처리함.
	//일반적으로 로그인, 세션 처리에 사용된다.
	//prehandle에서 세션 처리를 했다면 , 스프링 설정파일에 <Interceptors> 
	//맵핑 설정을 합니다. 
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
