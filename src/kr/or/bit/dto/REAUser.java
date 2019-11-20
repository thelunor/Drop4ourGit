package kr.or.bit.dto;

public class REAUser extends Users {	//중개사 DTO
	private String officeName;				//사무실 이름
	private String officeAddr;				//사무실 주소
	private String officeHp;		//사무실 번호
	private String regNum;					//사업자 등록번호
	
	public REAUser(){}

	public REAUser(String officeName, String officeAddr, String officeHp, String regNum) {
		super();
		this.officeName = officeName;
		this.officeAddr = officeAddr;
		this.officeHp = officeHp;
		this.regNum = regNum;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficeAddr() {
		return officeAddr;
	}

	public void setOfficeAddr(String officeAddr) {
		this.officeAddr = officeAddr;
	}

	public String getOfficeHp() {
		return officeHp;
	}

	public void setOfficeHp(String officeHp) {
		this.officeHp = officeHp;
	}

	public String getRegNum() {
		return regNum;
	}

	public void setRegNum(String regNum) {
		this.regNum = regNum;
	}

	@Override
	public String toString() {
		return "REAUser [officeName=" + officeName + ", officeAddr=" + officeAddr + ", officeHp=" + officeHp
				+ ", regNum=" + regNum + ", toString()=" + super.toString() + "]";
	}
	
	

}
