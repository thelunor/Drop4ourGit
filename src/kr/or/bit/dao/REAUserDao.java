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
import kr.or.bit.utils.DB_Close;

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
	         if (rs.next()) {
	            check = true;
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }

	      return check;
	}
	
	
	public int updateREAUser(REAUser user) { // 중개사회원 수정
		return 0;
	}
	
	public REAUser getREAMypage(String reaId) { // 중개사회원 마이페이지
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		REAUser reaUser = null;
		String sql = "select reaId, reaPwd, reaName, reaPhoneNum, officeName, officeAddr, officeDetailAddr, officeHp, regNum, userCode from REAUser where reaId=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reaId);
			reaUser = new REAUser();

			rs = pstmt.executeQuery();

			if (rs.next()) {
				reaUser.setReaId(rs.getString("reaId"));
				reaUser.setReaPwd(rs.getString("reaPwd"));
				reaUser.setReaName(rs.getString("reaName"));
				reaUser.setReaPhoneNum(rs.getString("reaPhoneNum"));
				reaUser.setOfficeName(rs.getString("officeName"));
				reaUser.setOfficeAddr(rs.getString("officeAddr"));
				reaUser.setOfficeDetailAddr(rs.getString("officeDetailAddr"));
				reaUser.setOfficeHp(rs.getString("officeHp"));
				reaUser.setRegNum(rs.getString("regNum"));
				reaUser.setUserCode(rs.getString("userCode"));
			}

		} catch (Exception e) {
			System.out.println("readEmp 오류");
		} finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return reaUser;
	}
}
