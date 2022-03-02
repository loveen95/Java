package com.zerock.testmapper;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisTest {
	/*테스트를 위한 준비 
	 * pom.xml의 JUnit 버전을 4.12로 변경. spring-test 라이브러리가 있어야함. 
	 * */
	

		
	

		@Autowired
		private SqlSessionFactoryBean session;
		@Autowired
		private DataSource dataSource;
		
		@Test
		public void testFactory() {
			try {
				System.out.println("주입성공" + session);
				System.out.println("----------------------");
				System.out.println("주입성공" + dataSource);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}



