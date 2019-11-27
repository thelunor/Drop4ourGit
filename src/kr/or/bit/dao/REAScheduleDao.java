package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.REASchedule;
import kr.or.bit.utils.DB_Close;

public class REAScheduleDao {
	DataSource ds = null;

	public REAScheduleDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}
	
	public int insertSchedule(REASchedule reaSchedule) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int resultRow = 0;
		try {
			conn = ds.getConnection();
			String sql_insertSchedule = "insert into REASchedule(scheNum, scheDate, content, reaId)"
					+"values(?, ?, ?, (select reaid from reauser where reaid=?))";
			pstmt = conn.prepareStatement(sql_insertSchedule);
			pstmt.setInt(1, reaSchedule.getScheNum());
			pstmt.setDate(2, new Date(reaSchedule.getScheDate().getTime())); 
			pstmt.setString(3, reaSchedule.getContent());
			pstmt.setString(4, reaSchedule.getReaId());			
			resultRow = pstmt.executeUpdate();
			
			if(resultRow > 0) {
				System.out.println("reaSchedule db 생성 완료");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			DB_Close.close(pstmt);
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultRow;		
	}
}
