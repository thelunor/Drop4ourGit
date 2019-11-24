package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.REAUser;
import kr.or.bit.dto.Sale;
import kr.or.bit.utils.DB_Close;

public class REAUserDao {
	DataSource ds = null;

	public REAUserDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public String REAUserLogin(String REAId, String REAPwd) { // 공인중개사회원 로그인 191121 이정은
		String userType = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ds.getConnection();
			String sql_REALogin = "select REAPwd, userCode from REAUser where REAId=? and REAPwd=?";
			pstmt = conn.prepareStatement(sql_REALogin);
			pstmt.setString(1, REAId);
			pstmt.setString(2, REAPwd);
			rs = pstmt.executeQuery();
			System.out.println("REA RS 호출 ****");
			if (rs.next()) {
				if (rs.getString("userCode").equals("B02")) {
					userType = "B02";
				} else if (!rs.getString("userCode").equals("B02")) {
					userType = "U02";
				}
			} else {
				userType = "false";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userType;
	}

	public int updateREAUser(REAUser reaUser) { // 중개사회원 수정
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("reaUser.toString(): " + reaUser.toString());
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			String sql = "update reaUser set reaPwd=?, reaName=?, reaPhoneNum=?, officeName=?, officeAddr=?,"
					+ "officeDetailAddr=?, officeHp=?, regNum=?, userCode=?, where reaId=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, reaUser.getReaPwd());
			pstmt.setString(2, reaUser.getReaName());
			pstmt.setString(3, reaUser.getReaPhoneNum());
			pstmt.setString(4, reaUser.getOfficeName());
			pstmt.setString(5, reaUser.getOfficeAddr());
			pstmt.setString(6, reaUser.getOfficeDetailAddr());
			pstmt.setString(7, reaUser.getOfficeHp());
			pstmt.setString(8, reaUser.getRegNum());
			pstmt.setString(9, reaUser.getUserCode());
			pstmt.setString(10, reaUser.getReaId());

			resultRow = pstmt.executeUpdate();

			if (resultRow > 0) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);

			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("update 예외");
			}

		}
		return resultRow;
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

	public List<REAUser> getREAUserList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<REAUser> rlist = null;

		try {
			conn = ds.getConnection();
			String sql = "select reaId, reaName, reaPhoneNum, officeName, officeAddr, officeHP, regNum "
					+ "from reauser where usercode=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "U02");
			rs = pstmt.executeQuery();
			rlist = new ArrayList<REAUser>();

			while (rs.next()) {
				REAUser reauser = new REAUser();

				reauser.setReaId(rs.getString("reaId"));
				reauser.setReaName(rs.getString("reaName"));
				reauser.setReaPhoneNum(rs.getString("reaPhoneNum"));
				reauser.setOfficeName(rs.getString("officeName"));
				reauser.setOfficeAddr(rs.getString("officeAddr"));
				reauser.setOfficeHp(rs.getString("officeHP"));
				reauser.setRegNum(rs.getString("regNum"));

				rlist.add(reauser);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return rlist;
	}
	
	public ArrayList<REAUser> getREAUserInfo(String reaId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<REAUser> rlist = null;

		String sql_get_REAInfo = "select officeName, officeDetailAddr, officeHp where reaId=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql_get_REAInfo);
			pstmt.setString(1, reaId);
			rs = pstmt.executeQuery();
			rlist = new ArrayList<REAUser>();


			while (rs.next()) {
				REAUser reauser = new REAUser();
				reauser.setOfficeName(rs.getString("officeName"));
				reauser.setOfficeAddr(rs.getString("officeAddr"));
				reauser.setOfficeHp(rs.getString("officeHP"));
				rlist.add(reauser);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rlist;
	}
	
	
	public REAUser getREAUserInfoByAptNum(String aptNum) {  //아파트 매물 번호로 공인중개사 아이디 찾기
		return null;
	}
}
