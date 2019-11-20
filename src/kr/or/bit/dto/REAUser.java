package kr.or.bit.dto;

public class REAUser {	//중개사 DTO
	private String id; 
	private String pwd;
	private String name;
	private String phoneNum;
	private String officeName;//사무실 이름
	private String officeAddr;	//사무실 주소
	private String officeHp; //사무실 번호
	private String regNum; //사업자 등록번호
	private String userType; //회원타입
	private String isBlack; //블랙회원여부
	
	public REAUser(){}

	public REAUser(String id, String pwd, String name, String phoneNum, String officeName, String officeAddr,
			String officeHp, String regNum, String userType, String isBlack) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phoneNum = phoneNum;
		this.officeName = officeName;
		this.officeAddr = officeAddr;
		this.officeHp = officeHp;
		this.regNum = regNum;
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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
		return "REAUser [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phoneNum=" + phoneNum + ", officeName="
				+ officeName + ", officeAddr=" + officeAddr + ", officeHp=" + officeHp + ", regNum=" + regNum
				+ ", userType=" + userType + ", isBlack=" + isBlack + ", toString()=" + super.toString() + "]";
	}

	
	

}
