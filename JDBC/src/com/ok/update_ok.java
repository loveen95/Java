package com.ok;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/update_ok")
public class update_ok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public update_ok() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //form 데이터처리 
		request.setCharacterEncoding("utf-8");
	     String id = request.getParameter("id");
	     String pw = request.getParameter("pw");
	     String name = request.getParameter("name");
	     String phone1 = request.getParameter("phone1");
	     String phone2 = request.getParameter("phone2");
	     String gender = request.getParameter("gender");
	     String email = request.getParameter("email");
	     //1. 폼 데이터 값 저장(VO에 저장)
	     MemberVO vo = new MemberVO(id,pw,name,phone1,phone2,email,gender);
	     //2. DAO객체 생성. update()사용
	     MemberDAO dao = MemberDAO.getInstance();
	    
	     int result = dao.update(vo);
	     
	     if(result == 1) {
	    	 response.sendRedirect("update_success.jsp");
	     }else {
	    	 response.sendRedirect("mypage.jsp");
	     }
	     
	     /*
	      * 
	      * 
	      * 1. 폼 데이터 값을 VO에 저장
	      * 2. DAO 객체를 생성하고, update 메서드로 vo객체를 전달
	      * 3. update 메서드 안에서는 executeUpdate()메서드로 실행
	      * 	1을 반한하면 update_success.jsp로 이동
	      * 	0을 반환하면 mypage.jsp로 이동
	      * 
	      * */
	    

		
		
	     
	}

}
