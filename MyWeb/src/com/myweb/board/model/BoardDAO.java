package com.myweb.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.myweb.util.JdbcUtil;

public class BoardDAO {
	
	//1. 스스로 객체를 멤버변수로 선언하고 1개 제한 - 싱글톤
	private static BoardDAO instance = new BoardDAO();
	
	//2.외부에서 작업 못하도록 설정
	private BoardDAO() {
		
		try {
			InitialContext ctx = new InitialContext(); //context.xml에 저장된 설정을 저장하는 기능
			ds =(DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
		}catch (Exception e) {
			System.out.println("커넥션 풀링 에러 발생");
		}
	}
	//3.외부에서 객체를 요구할때 getter 메서드만 써서 반환
	public static BoardDAO getInstance() {
		return instance;
	}
	//-----------------중복되는 코드를 멤버 변수로 선언----------------------
	private DataSource ds;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	//---------------------메서드 구현-------------------------------------
	//게시글 등록 메서드 구현
	public int regist(String writer,String title, String content) {
		int result = 0;   // 반환값을 해도 되고 안해도됨 없으면 void 
		
		String sql = "insert into board(writer, title, content) values(?,?,?)";
	
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, writer);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			result = pstmt.executeUpdate();
	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return result;
	}
	//게시물 목록 조회 리스트 
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> list = new ArrayList<>();
	
		String sql = "select * from board order by num desc";
			
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
	
			rs = pstmt.executeQuery();
			while(rs.next()) {
			
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp regdate = rs.getTimestamp("regdate");
				int hit = rs.getInt("hit");
				
				BoardVO vo = new BoardVO(num, writer, title, content, regdate, hit);
				
				list.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return list;	
	
	}
	public BoardVO getContent(String num) {
		BoardVO vo = null;
		
		String sql = "select * from board where num=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			int num1 = rs.getInt("num");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			int hit = rs.getInt("hit");
			String content = rs.getString("content");
			Timestamp regdate = rs.getTimestamp("regdate");
			
			vo = new BoardVO(num1, writer, title, content, regdate, hit);
	
			}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	public void update(String num, String title, String content) {
	
		
		String sql = "update board set title=?, content=? where num=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Integer.parseInt(num)); 
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {		
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

	}
	//게시글 삭제 반환값 X
	public void delete(String num) {

		String sql = "delete from board where num=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
		
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}

		
	}
	public void upHit(String num) {
		
		String sql = "Update board set hit = hit + 1 where num=?";
		
		try {
			conn = ds.getConnection();
			pstmt= conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result);

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
	}
	
}







