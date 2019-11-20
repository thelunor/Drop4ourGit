package kr.or.bit.dto;

public class Users {					
	private String id;	//아이디			
	private String pwd; //패스워드
	private String name; //이름
	private String phoneNum; //휴대폰번호
	private String isBlack;	//블랙리스트 여부
	private String userCode;//회원 코드
	
	public Users() {
		
	}
	
	public Users(String id, String pwd, String name, String phoneNum, String isBlack, String userCode) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phoneNum = phoneNum;
		this.isBlack = isBlack;
		this.userCode = userCode;
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getIsBlack() {
		return isBlack;
	}

	public void setIsBlack(String isBlack) {
		this.isBlack = isBlack;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phoneNum=" + phoneNum + ", isBlack=" + isBlack
				+ ", userCode=" + userCode + "]";
	}
	
}
