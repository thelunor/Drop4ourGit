package kr.or.bit.dto;

public class SaleImage { //매물이미지
	private String aptNum; //매물번호
	private String aptImgName; //매물사진 파일명
	private String aptImgPath; //매물사진 파일경로
	
	public SaleImage() {}

	public SaleImage(String aptNum, String aptImgName, String aptImgPath) {
		super();
		this.aptNum = aptNum;
		this.aptImgName = aptImgName;
		this.aptImgPath = aptImgPath;
	}

	public String getAptNum() {
		return aptNum;
	}

	public void setAptNum(String aptNum) {
		this.aptNum = aptNum;
	}

	public String getAptImgName() {
		return aptImgName;
	}

	public void setAptImgName(String aptImgName) {
		this.aptImgName = aptImgName;
	}

	public String getAptImgPath() {
		return aptImgPath;
	}

	public void setAptImgPath(String aptImgPath) {
		this.aptImgPath = aptImgPath;
	}

	@Override
	public String toString() {
		return "SaleImage [aptNum=" + aptNum + ", aptImgName=" + aptImgName + ", aptImgPath=" + aptImgPath
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
