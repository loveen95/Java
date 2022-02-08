package com.myweb.user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;

public class UserDAO {
/*
 * DAO 단수 DB연동을 담당하는 클래스 
 * 여러개 생성하도록 일반 클래스로 만들면 , 메모리 과부하가 올 수 있다.
 * 싱글톤 패턴을 적용해서 객체를 한개로 제한
 * 
 * *
  */
	
	private DataSource ds;
	private Context ct; 
  	
	private static UserDAO instance = new UserDAO();   
	
	private UserDAO() {
		try {
			ct = new InitialContext();		
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/oracle");
		}catch(Exception e) {
			System.out.println("Connection Pool error");
		}
	}
	public static UserDAO getInstance() {		
		return instance;
	}
	

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//-----------------------------메서드 선언-------------------------
	
	//id확인 메서드
	public int idConfirm (String id) {		
		int result= 0;
		String sql = "select * from users where id=?";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery(); 
			
			if(rs.next()) {
				result = 1;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.close(conn, pstmt, rs);
				
			}catch (Exception e2) {
				
			}
		}
	
		return result;
		
	}
	public int join (UserVO vo) {
		int result = 0;
		
		String sql = "insert into users(id, pw, name, email, address) values(?,?,?,?,?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getAddress());
			
			result = pstmt.executeUpdate();
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.close(conn, pstmt, rs);
			}catch (Exception e2) {
				System.out.println("알수없는 에러!!");
			}
		}
	
		return result;
	}
	
	
	public int login(String id,String pw) {
	
		int result = 0;
		
		
		String sql = "select * from users where id=? and pw=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			//sql 실행 
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result=1;
			}else {
				result = 0;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { 
				JdbcUtil.close(conn, pstmt, rs);
			}catch (Exception e2) {
			
			}
		}
		
		return result;
	}
	public UserVO getUserInfo(String id1) {
         UserVO vo = null;
         
         String sql = "select * from users where id=?";
         
         try {
        	 conn = ds.getConnection();
        	 pstmt = conn.prepareStatement(sql);
        	 
        	 pstmt.setString(1, id1);
        	 
        	 rs = pstmt.executeQuery();
        	 
        	 if(rs.next()) {
        		 //DB에서 getString(컬럼명), getTimeStamp(컬럼명) 메서드를 이용
        		 String id = rs.getString("id");
        		 String name = rs.getString("name");
        		 String email = rs.getString("email");
        		 String address = rs.getString("address");
        		 Timestamp regdate =rs.getTimestamp("regdate");
        		 
        		 vo = new UserVO(id1, null, name, email, address, regdate);
        
        	 }else {
        		 
        	 }
        	 
        	 
         }catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcUtil.close(conn, pstmt, rs);
			}catch (Exception e2) {
		
			}
			
		}
         
    
        return vo; 
	}
	
	public int changePassword(String id1, String newpw) {
		int result = 0;
		
		String sql = "update users set pw = ? where id =? ";
		
	
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newpw);
			pstmt.setString(2, id1);
			
			result = pstmt.executeUpdate();
			
		
		}catch (Exception e) {

		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
			
		return result;
		
	}  //회원 정보 수정 업데이트
	public int update(UserVO vo) {
		int result = 0;
		
		String sql = "Update users Set name =?, email =?, address=? where id = ?";
		
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getId());
			
			result = pstmt.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		
		return result;
		
	} //회원삭제
	public int delete(String id) {
		int result = 0;
		
		String sql = "delete from users where id = ?"; 
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
			
		}catch (Exception e) {
			
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;

	}
}


