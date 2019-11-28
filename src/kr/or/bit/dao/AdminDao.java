package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.Admin;
import kr.or.bit.dto.GenericUser;
import kr.or.bit.dto.REAImage;
import kr.or.bit.dto.REAUser;
import kr.or.bit.utils.DB_Close;

public class AdminDao {
	/*
	 * 로그인 체크, 모든 회원 검색, 타입별 회원 모두 검색, 아이디로 일반유저 찾기, 주민번호로 일반유저 찾기, 아이디로 중개사유저 찾기,
	 * 사업자등록번호로 중개사유저 찾기, 일반회원 추가 삭제, 공인중개사 추가 삭제, 블랙리스트 추가 삭제 기능 클래스
	 */
	DataSource ds = null;

	public AdminDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public boolean adminLogin(String adminId, String adminPwd) { // 관리자 로그인 191121 이정은
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql_adminLogin = "select adminPwd from Admin where adminId=? and adminPwd=?";
			pstmt = conn.prepareStatement(sql_adminLogin);
			pstmt.setString(1, adminId);
			pstmt.setString(2, adminPwd);
			rs = pstmt.executeQuery();
			System.out.println("AdminRS 호출 ****");
			if (rs.next()) {
				check = true;
				System.out.println("Admin 로그인 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB_Close.close(rs);
			DB_Close.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("GenericUserLogin 예외");
			}
		}
		return check;
	}

	public List<GenericUser> selectGenericUser() { // 일반 회원 검색
		return null;
	}

	public List<REAUser> selectREAUser() { // 공인중개사 회원 검색
		return null;
	}

	public GenericUser getGenericUserById(String id) { // 아이디로 일반유저 찾기
		return null;
	}

	public GenericUser getGenericUserByRes(String resNum) { // 주민번호로 일반유저 찾기
		/* DB에 주민번호 앞자리, 뒷자리로 컬럼 나눠져 있음. 파라미터로 받은 주민번호 잘라서 DB에서 찾기 */
		return null;
	}

	public REAUser getREAUserById(String id) { // 아이디로 중개사유저 찾기
		return null;
	}

	public REAUser getREAUserByReg(String regNum) { // 사업자등록번호로 중개사유저 찾기
		return null;
	}

	public int insertGenericUser(GenericUser user) { // 일반회원 추가
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("얖");
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			// 개인회원 db 저장 (9개 데이터)
			String sql_insert_genericuser = "insert into genericuser(userid,userpwd,username,frontResNum,backResNum,userPhoneNum,useraddr,userDetailAddr,userCode)"
					+ " values(?,?,?,?,?,?,?,?,(select usercode from usercode where usercode=?))";
			pstmt = conn.prepareStatement(sql_insert_genericuser);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPwd());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getFrontResNum());
			pstmt.setString(5, user.getBackResNum());
			pstmt.setString(6, user.getUserPhoneNum());
			pstmt.setString(7, user.getUserAddr());
			pstmt.setString(8, user.getUserDetailAddr());
			pstmt.setString(9, user.getUserCode());

			resultRow = pstmt.executeUpdate();
			if (resultRow > 0) {
				System.out.println(" dao 완료");
			}

		} catch (Exception e) {
			System.out.println("InsertDao 실패 : " + e.getMessage());

		} finally {
			DB_Close.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultRow;
	}

	public int insertREAUser(REAUser user, REAImage reaImg) { // 중개사회원 추가
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultRow = 0;
		System.out.println("user.toString() "+user.toString());
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false); // 트랜잭션
			// 1. 공인중개사 회원 db 저장 (10개 데이터)
			String sql_insert_reauser = "insert into REAUSER(reaId,reaPwd,reaName,reaPhoneNum,officeName,officeAddr,officeDetailAddr,officeHp,regNum,userCode)"
					+ " values(?,?,?,?,?,?,?,?,?,(select usercode from usercode where usercode=?))";
			pstmt = conn.prepareStatement(sql_insert_reauser);
			pstmt.setString(1, user.getReaId());
			pstmt.setString(2, user.getReaPwd());
			pstmt.setString(3, user.getReaName());
			pstmt.setString(4, user.getReaPhoneNum());
			pstmt.setString(5, user.getOfficeName());
			pstmt.setString(6, user.getOfficeAddr());
			pstmt.setString(7, user.getOfficeDetailAddr());
			pstmt.setString(8, user.getOfficeHp());
			pstmt.setString(9, user.getRegNum());
			pstmt.setString(10, "U02");

			resultRow = pstmt.executeUpdate();

			String sql_insert_reaimg = "insert into reaimage(reaId, reaImgOriginName,reaImgSaveName) values(?,?,?)";
			pstmt = conn.prepareStatement(sql_insert_reaimg);
			pstmt.setString(1, reaImg.getReaId());
			pstmt.setString(2, reaImg.getReaImgOriginName());
			pstmt.setString(3, reaImg.getReaImgSaveName());
			resultRow = pstmt.executeUpdate();

			if (resultRow > 0) {
				System.out.println(" dao commit 완료");
				conn.commit(); // 2개의 insert 완료시
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			DB_Close.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultRow;
	}

	public int deleteGenericUser(String id) { // 일반회원 삭제
		return 0;
	}

	public int deleteREAUser(String id) { // 중개사회원 삭제
		return 0;
	}

	public int updateBlack(GenericUser user) { // 블랙리스트 추가/삭제
		/*
		 * if(user.black ==1){ user.black=0; } else{ user.black=1; }
		 */
		return 0;
	}

}
