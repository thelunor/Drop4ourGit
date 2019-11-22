package kr.or.bit.dto;


public class SaleImage { //매물이미지
	private int saleImgNum; //매물 사진 번호
	private String saleImgOriginName; //매물사진 원본 파일명
	private String saleImgSaveName; //매물사진 저장 파일명
	private String aptNum; //매물번호

	
	public SaleImage() {}


	public SaleImage(int saleImgNum, String saleImgOriginName, String saleImgSaveName, String aptNum) {
		super();
		this.saleImgNum = saleImgNum;
		this.saleImgOriginName = saleImgOriginName;
		this.saleImgSaveName = saleImgSaveName;
		this.aptNum = aptNum;
	}


	public int getSaleImgNum() {
		return saleImgNum;
	}


	public void setSaleImgNum(int saleImgNum) {
		this.saleImgNum = saleImgNum;
	}


	public String getSaleImgOriginName() {
		return saleImgOriginName;
	}


	public void setSaleImgOriginName(String saleImgOriginName) {
		this.saleImgOriginName = saleImgOriginName;
	}


	public String getSaleImgSaveName() {
		return saleImgSaveName;
	}


	public void setSaleImgSaveName(String saleImgSaveName) {
		this.saleImgSaveName = saleImgSaveName;
	}


	public String getAptNum() {
		return aptNum;
	}


	public void setAptNum(String aptNum) {
		this.aptNum = aptNum;
	}


	@Override
	public String toString() {
		return "SaleImage [saleImgNum=" + saleImgNum + ", saleImgOriginName=" + saleImgOriginName + ", saleImgSaveName="
				+ saleImgSaveName + ", aptNum=" + aptNum + ", toString()=" + super.toString() + "]";
	}


	


}
