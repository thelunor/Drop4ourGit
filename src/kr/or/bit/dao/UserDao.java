package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.GenericUser;
import kr.or.bit.dto.REAUser;
import kr.or.bit.dto.Users;

public class UserDao {
	/*
	 * 로그인 체크, 모든 회원 검색, 타입별 회원 모두 검색, 아이디로 일반유저 찾기, 주민번호로 일반유저 찾기, 아이디로 중개사유저 찾기,
	 * 사업자등록번호로 중개사유저 찾기, 일반회원 추가 삭제, 공인중개사 추가 삭제, 블랙리스트 추가 삭제 기능 클래스
	 */
	DataSource ds = null;

	public UserDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}

	public boolean userLogin(String id, String pwd) { // 로그인
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			
			String sql = "SELECT PWD FROM USERS WHERE ID=? and PWD=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				check = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
		return check;
	}

	public List<Users> selectAllUser() { // 모든 회원 검색
		return null;
	}

	public List<Users> selectAllTypeUser(String userCode) { // 타입별로 회원 모두 검색
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
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into usertable() ";
		}catch(Exception e) {
			
		}finally {
			
		}
		return resultRow;
	}

	public int insertREAUser(REAUser user) { // 중개사회원 추가
		return 0;
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
