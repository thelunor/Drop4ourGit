package kr.or.bit.dto;

public class REAImage {					//중개사 이미지 DTO
	private String id;						//중개사 아이디
	private String reaImgName;	//중개사 이미지파일명
	private String reaImgPath;		//중개사 이미지파일 경로
	private String officeImgName;	//사무실 이미지파일명
	private String officeImgPath;	//사무실 이미지파일 경로
	
	public REAImage() {}

	public REAImage(String id, String reaImgName, String reaImgPath, String officeImgName, String officeImgPath) {
		super();
		this.id = id;
		this.reaImgName = reaImgName;
		this.reaImgPath = reaImgPath;
		this.officeImgName = officeImgName;
		this.officeImgPath = officeImgPath;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReaImgName() {
		return reaImgName;
	}

	public void setReaImgName(String reaImgName) {
		this.reaImgName = reaImgName;
	}

	public String getReaImgPath() {
		return reaImgPath;
	}

	public void setReaImgPath(String reaImgPath) {
		this.reaImgPath = reaImgPath;
	}

	public String getOfficeImgName() {
		return officeImgName;
	}

	public void setOfficeImgName(String officeImgName) {
		this.officeImgName = officeImgName;
	}

	public String getOfficeImgPath() {
		return officeImgPath;
	}

	public void setOfficeImgPath(String officeImgPath) {
		this.officeImgPath = officeImgPath;
	}

	@Override
	public String toString() {
		return "REAImage [id=" + id + ", reaImgName=" + reaImgName + ", reaImgPath=" + reaImgPath + ", officeImgName="
				+ officeImgName + ", officeImgPath=" + officeImgPath + ", toString()=" + super.toString() + "]";
	}
	
	
}
