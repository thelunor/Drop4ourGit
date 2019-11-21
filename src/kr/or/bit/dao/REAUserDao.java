package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.REAUser;

public class REAUserDao {
	DataSource ds = null;

	public REAUserDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public boolean REAUserLogin(String REAId, String REAPwd) { // 공인중개사회원 로그인 191121 이정은
	      boolean check = false;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      try {
	         conn = ds.getConnection();
	         String sql_REALogin = "select REAPwd from REAUser where REAId=? and REAPwd=? and userCode=?";
	         pstmt = conn.prepareStatement(sql_REALogin);
	         pstmt.setString(1, REAId);
	         pstmt.setString(2, REAPwd);
	         pstmt.setString(3, "U02");	         
	         rs = pstmt.executeQuery();
	         System.out.println(rs);
	         if (rs.next()) {
	            check = true;
	            System.out.println(check + "얍");
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

	      return check;
	}
	
	
	public int updateREAUser(REAUser user) { // 중개사회원 수정
		return 0;
	}
	
	public REAUser getREAMypage() { //중개사회원 마이페이지
		
		return null;
	}
}
