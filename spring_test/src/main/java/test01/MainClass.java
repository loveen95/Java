package test01;


import java.sql.ResultSet;

import org.springframework.context.support.GenericXmlApplicationContext;

import test02.ex02.setter.DatabaseDev;
import test02_ex01.contruct.Hotel;

public class MainClass {

	public static void main(String[] args) {
		//SpringTest st = new SpringTest(); 
		//st.method();
		
		String resources = "classpath:applicationContext.xml";
		
		GenericXmlApplicationContext ct //ct엔 applicationContext.xml 이 들어있다.
		= new GenericXmlApplicationContext(resources);
		
		SpringTest test = ct.getBean("good", SpringTest.class);
		test.method();
		
		//ApplicationContext.xml에서 정의된 Bean을 호출
		Hotel hotel = ct.getBean("hotel", Hotel.class);
		//XML에 정의된 DI에 의해서 Chef 클래스를 별로 불러오지않고, 정의하지 않은 상태에서 불러옴
		//의존성 주입 처리됨
		hotel.getChef().cook();
		
	

		
		DatabaseDev dv = ct.getBean("DBdev", DatabaseDev.class);
	    
		dv.test();
		ResultSet rs = dv.testQuery("select * from users");
		try {
			System.out.println(rs.getString("id") + rs.getString("pw"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	
		ct.close();

}

	}
	
		//setter를 통해 값을 받고 있기 때문에 객체를 생성하고 세터 지정후 반환합니다.
	