package com.zerock.util;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component  //bean 자동 생성명령(컴포넌트 스캔에 추가)
@Aspect     //Aspect 클래스를 의미  
public class LogAdvice {
//	해당 기능은 로그를 출력할 수 있는 기능
//	log4j.xml에 레벨설정해야함
//	<logger name="com.zerock.util">
//		<level value="info" />
//	</logger>	
	
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	//맨앞에 있는 *은 접근 제한자를 의미하고, 맨뒤에 *는 메서드를 의미함. 
	@Before("execution(* com.zerock.board.service.BoardServiceImpl*.*(..))")
	//@Before("execution(* com.zerock.controller.*Controller*.*(..))")
	public void beforeLog() {
		logger.info("-----Before-----");
	}
	
	//이후 AOP설정!
	
	@After("execution(* com.zerock.board.service.BoardServiceImpl.*(..))")
	public void afterLog() {
		logger.info("-----After-----");
		
	}
	
	//매서드 실행 권한을 가지고 , 실행전, 실행 후 처리가 가능
	//@Around가 적용된는 메서드(어드바이스)는 반드시 리턴이 있어야 합니다. 
	@Around("execution(* com.zerock.board.service.BoardServiceImpl.*(..))")
	public Object aroundLog(ProceedingJoinPoint jp) {
		long start = System.currentTimeMillis();
		
		//해당 기능을 통해서 메서드 실행전 결과를 확인 할 수 있음. 
		//System.out.println("적용클래스: " + jp.getTarget());
		//System.out.println("적용파라미터 : "+ Arrays.toString(jp.getArgs()));
		
		logger.info("적용클래스 : " + jp.getTarget());
		logger.info("적용파라미터 : "+ Arrays.toString(jp.getArgs()));
		
		Object result = null;
		
		try {
			//proceed()는 타겟메서드를 지칭한다. 해당 메서드를 실행 시켜야 타켓이 되는 메서드가 실행된다. 
			//해당 메서드를 만나기 전까지 Before 어드바이스가 실행된다. 
			result = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		//System.out.println("메서드수행에 걸린 시간 : " + (end - start));
		logger.info("메서드수행에 걸린 시간 : " + (end - start));
		
		return result;
		
	}
	
	//해당 어노테이션은 예외가 발생하면 동작하는 어노테이션
	//pointcut - 어떤 메서드에 적용할 것인
	//throwing - 처리할 에러 변수
	@AfterThrowing(pointcut="execution(* com.zerock.service.memberService*.*(..))"
			, throwing = "e")
	public void errorLog(Exception e) {
		System.out.println("에러 출력 : "+ e);
	}
	
	
	
	
	

}
