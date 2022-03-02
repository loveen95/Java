package com.zerock.JDBCTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

	//단위테스트를 스프링과 연동
	@RunWith(SpringJUnit4ClassRunner.class)
	//환경설정 파일 명시
	@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
	public class JdbcTemplateTest {
		//spring-test라이브러리가 추가 되어 있어야함
		//run as ->JUnitTest(@Test 어노테이션으로 JUnit 사용이 가능)
		@Autowired //autowired는 데이터타입을 먼저 본다 -> Datasource타입을 먼저 찾음 ->변수명 순으로
		DataSource datasource;
		
		@Autowired //autowired는 데이터타입을 먼저 본다 -> JdbcTemplate 타입을 먼저 찾음 ->변수명 순으로
		JdbcTemplate jdbcTemplate; 
		
		@Test
		public void testTemplate() {
			try {
				Connection conn = datasource.getConnection();
				System.out.println(">>>>>>>>>connection 출력 :" +conn);
				System.out.println(">>>>>>>>>템플릿 객체 생성 : " +jdbcTemplate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

	}



