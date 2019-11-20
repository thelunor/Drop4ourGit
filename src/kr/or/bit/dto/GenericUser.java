package kr.or.bit.dto;

public class GenericUser extends Users{	//일반회원 DTO
	private String frontResNum; //주민등록번호 앞자리
	private String backResNum; //주민등록번호 뒷자리
	private String addr;			//주소
	
	public GenericUser() {
	}

	public GenericUser(String frontResNum, String backResNum, String addr) {
		super();
		this.frontResNum = frontResNum;
		this.backResNum = backResNum;
		this.addr = addr;
	}

	public String getFrontResNum() {
		return frontResNum;
	}

	public void setFrontResNum(String frontResNum) {
		this.frontResNum = frontResNum;
	}

	public String getBackResNum() {
		return backResNum;
	}

	public void setBackResNum(String backResNum) {
		this.backResNum = backResNum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "GenericUser [frontResNum=" + frontResNum + ", backResNum=" + backResNum + ", addr=" + addr
				+ ", toString()=" + super.toString() + "]";
	}

	
}
