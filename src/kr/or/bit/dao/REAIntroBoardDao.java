package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.REAIntroBoard;
import kr.or.bit.utils.DB_Close;

public class REAIntroBoardDao {

	DataSource ds = null;

	public REAIntroBoardDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}
	/* 소개 페이지 넣기, 읽기, 수정, 삭제 */

	public int insertREAIntro(REAIntroBoard reaintro) { // 소개 페이지 넣기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			String sql_insert_reaIntro = "insert into reaintroboard(reaid, subject, content)"
					+"values((select reaid from reauser where reaid=?), ?, ?)";
			pstmt = conn.prepareStatement(sql_insert_reaIntro);
			pstmt.setString(1, reaintro.getId());
			pstmt.setString(2, reaintro.getSubject());
			pstmt.setString(3, reaintro.getContent());
			resultRow = pstmt.executeUpdate();
			if(resultRow > 0) {
				System.out.println("소개 페이지 db 등록 완료");
			}
						
		} catch (Exception e) {
			System.out.println("insertREAIntro 예외발생");
			System.out.println(e.getMessage());
		} finally {
			DB_Close.close(pstmt);
			try {
				conn.close(); // 반환하기
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return resultRow;
	}

	public REAIntroBoard getREAIntroData(String id) { // 소개 읽기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		REAIntroBoard reaIntro = null;
		
		try {
			conn = ds.getConnection();
			System.out.println("디비디비비디비");
			String select_sql = "SELECT REAID, SUBJECT, CONTENT "
								+ "FROM REAINTROBOARD WHERE REAID=?";
			pstmt = conn.prepareStatement(select_sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println("getREAIntro rs 성공");
				
				String reaId = rs.getString("reaId");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				reaIntro = new REAIntroBoard(reaId, subject, content);

			}
		} catch (Exception e) {
			System.out.println("getREAIntroDao 예외발생");
			System.out.println(e.getMessage());
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close(); // 반환하기
			} catch (Exception e) {
				System.out.println("getREAIntroDao finally 예외발생");
				System.out.println(e.getMessage());
			}
		}
		
		return reaIntro;
	}

	public int updateREAIntro(REAIntroBoard reaintro) { // 소개 수정
		return 0;
	}

	public int deleteREAIntro(String reaid) { // 소개 삭제(공인중개사 id로)
		return 0;
	}
	
	public boolean checkREAIntro(String reaId) {
		boolean check = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql_check = "select subject, content from reaintroboard where reaid=?";
			pstmt = conn.prepareStatement(sql_check);
			pstmt.setString(1, reaId);
			rs = pstmt.executeQuery();
			if(rs.next()) { 
				check=true; //이미 등록된 소개글이 있다면
			}else {
				check=false;
			}
		}catch(Exception e) {
			
		}finally {
			DB_Close.close(pstmt);
			try {
				conn.close(); // 반환하기
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return check;
	}
}
