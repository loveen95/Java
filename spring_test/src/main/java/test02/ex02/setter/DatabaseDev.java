package test02.ex02.setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.sql.DataSource;

import test02.ex02.setter.DatabaseDev;

public class DatabaseDev {	
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String uid;
	private String upw;
	private String url;
	private Connection conn;
	private PreparedStatement pstmt;

	public DatabaseDev() {
		
	} 
	
	   public void test() {
		      try {
		         this.conn = DriverManager.getConnection(url, uid, upw);
		         System.out.println("연결 성공");
		      } catch (Exception e) {
		         System.out.println("연결 실패");
		         e.printStackTrace();
		      }
		      
		      System.out.println(this.url);
		      System.out.println(this.uid);
		      System.out.println(this.upw);
		   }
		   
		   
		   
		   
		   public ResultSet testQuery(String sql) {
		      ResultSet rs = null;
		      
		      try {
		         this.conn = DriverManager.getConnection(url, uid, upw);
		         this.pstmt = conn.prepareStatement(sql);
		         rs = pstmt.executeQuery();
		         
		         if (rs.next()) {
		            System.out.println("testQuery() 성공");
		         } else System.out.println("실패");
		         
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		      
		      return rs;
		   }


	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	


	



}
