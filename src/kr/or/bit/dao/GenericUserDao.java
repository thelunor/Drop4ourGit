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
import kr.or.bit.utils.DB_Close;

public class GenericUserDao {

	DataSource ds = null;

	public GenericUserDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public String GenericUserLogin(String userId, String userPwd) { // 일반회원 로그인 191121 이정은
		String userType = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			String sql_genericUserLogin = "select userPwd, userCode from GenericUser where userId=? and userPwd=?";
			pstmt = conn.prepareStatement(sql_genericUserLogin);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			rs = pstmt.executeQuery();
			System.out.println("GenericRS 호출 ****");
			if (rs.next()) {
				if (rs.getString("userCode").equals("B01")) {
					userType = "B01";
				} else if (!rs.getString("userCode").equals("B01")) {
					userType = "U01";
				}
			} else {
				userType = "false";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userType;
	}

	public int updateGenericUser(GenericUser user) { // 일반회원 수정
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			String sql_update_genericUser = "update GENERICUSER set userpwd=?, username=?, userphonenum=?,"
					+"useraddr=?, userdetailAddr=? where userid=?";
			
			pstmt = conn.prepareStatement(sql_update_genericUser);
			pstmt.setString(1, user.getUserPwd());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPhoneNum());
			pstmt.setString(4, user.getUserAddr());
			pstmt.setString(5, user.getUserDetailAddr());
			pstmt.setString(6, user.getUserId());
			
			resultRow = pstmt.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			
		}
		return resultRow;
	}

}
