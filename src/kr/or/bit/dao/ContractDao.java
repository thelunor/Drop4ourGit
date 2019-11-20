package kr.or.bit.dao;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.bit.dto.Contract;

public class ContractDao {
	/*
	 *	공인중개사 아이디로 계약서 찾기, 매물번호로 계약서 찾기, 계약서 추가, 수정, 삭제 클래스 
	 */
	DataSource ds = null;

	public ContractDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	}
	public List<Contract> selectAllContracts(String id){ //공인중개사 아이디가 갖는 모든 계약서 가져오기
		//쿼리문 두개써서 잘 해봅시다 ^^. . .
		return null;
	}
	
	public Contract getContract(String aptNum) { //매물번호로 계약서 찾기
		return null;
	}
	
	public int insertContract(Contract contract) { //계약서 추가
		
		return 0;
	}
	
	public int updateContract(Contract contract) { //계약서 수정
		
		return 0;
	}
	
	public int deleteContract(String aptNum) {	//계약서 삭제
		
		return 0;
	}
	
}
