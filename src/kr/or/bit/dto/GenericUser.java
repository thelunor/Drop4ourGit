package kr.or.bit.dto;

public class GenericUser{	//일반회원 DTO
	private String id; 
	private String pwd;
	private String name;
	private String frontResNum; //주민등록번호 앞자리
	private String backResNum; //주민등록번호 뒷자리
	private String phoneNum;
	private String addr; //주소
	private String detailAddr; //상세주소
	private String userType; //회원타입
	private String isBlack; //블랙회원여부
	
	public GenericUser() {}

	public GenericUser(String id, String pwd, String name, String frontResNum, String backResNum, String phoneNum,
			String addr, String detailAddr, String userType, String isBlack) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.frontResNum = frontResNum;
		this.backResNum = backResNum;
		this.phoneNum = phoneNum;
		this.addr = addr;
		this.detailAddr = detailAddr;
		this.userType = userType;
		this.isBlack = isBlack;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getIsBlack() {
		return isBlack;
	}

	public void setIsBlack(String isBlack) {
		this.isBlack = isBlack;
	}

	@Override
	public String toString() {
		return "GenericUser [id=" + id + ", pwd=" + pwd + ", name=" + name + ", frontResNum=" + frontResNum
				+ ", backResNum=" + backResNum + ", phoneNum=" + phoneNum + ", addr=" + addr + ", detailAddr="
				+ detailAddr + ", userType=" + userType + ", isBlack=" + isBlack + ", toString()=" + super.toString()
				+ "]";
	}



	
}
