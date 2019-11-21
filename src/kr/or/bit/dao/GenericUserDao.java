package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.GenericUser;

public class GenericUserDao {

	DataSource ds = null;

	public GenericUserDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public boolean GenericUserLogin(String userId, String userPwd) { // 일반회원 로그인 191121 이정은
	      boolean check = false;
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;

	      try {
	         conn = ds.getConnection();
	         String sql_genericUserLogin = "select userPwd from GenericUser where userId=? and userPwd=? and userCode=?";
	         pstmt = conn.prepareStatement(sql_genericUserLogin);
	         pstmt.setString(1, userId);
	         pstmt.setString(2, userPwd);
	         pstmt.setString(3, "U01");
	         rs = pstmt.executeQuery();	         
	         if (rs.next()) {
	            check = true;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

	      return check;
	}
	
	
	public int updateGenericUser(GenericUser user) { // 일반회원 수정
		return 0;
	}
	

}
