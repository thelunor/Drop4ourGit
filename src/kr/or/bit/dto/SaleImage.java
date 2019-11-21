package kr.or.bit.dto;

public class SaleImage { //매물이미지
	private int saleImgNum; //매물 사진 번호
	private String saleImgName; //매물사진 파일명
	private String saleImgPath; //매물사진 파일경로
	private String aptNum; //매물번호

	
	public SaleImage() {}


	public SaleImage(int saleImgNum, String saleImgName, String saleImgPath, String aptNum) {
		super();
		this.saleImgNum = saleImgNum;
		this.saleImgName = saleImgName;
		this.saleImgPath = saleImgPath;
		this.aptNum = aptNum;
	}


	public int getSaleImgNum() {
		return saleImgNum;
	}


	public void setSaleImgNum(int saleImgNum) {
		this.saleImgNum = saleImgNum;
	}


	public String getSaleImgName() {
		return saleImgName;
	}


	public void setSaleImgName(String saleImgName) {
		this.saleImgName = saleImgName;
	}


	public String getSaleImgPath() {
		return saleImgPath;
	}


	public void setSaleImgPath(String saleImgPath) {
		this.saleImgPath = saleImgPath;
	}


	public String getAptNum() {
		return aptNum;
	}


	public void setAptNum(String aptNum) {
		this.aptNum = aptNum;
	}


	@Override
	public String toString() {
		return "SaleImage [saleImgNum=" + saleImgNum + ", saleImgName=" + saleImgName + ", saleImgPath=" + saleImgPath
				+ ", aptNum=" + aptNum + ", toString()=" + super.toString() + "]";
	}


	

	
	
}
