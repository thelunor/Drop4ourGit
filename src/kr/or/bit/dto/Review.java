package kr.or.bit.dto;

import java.util.Date;

public class Review {					//후기 DTO
	private int reviewNum;			//후기 번호
	private String id;					//후기 작성자 아이디
	private String reviewContent;	//후기 내용
	private Date reviewDate;		//후기 작성 시간
	
	public Review() {}

	public Review(int reviewNum, String id, String reviewContent, Date reviewDate) {
		super();
		this.reviewNum = reviewNum;
		this.id = id;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "Review [reviewNum=" + reviewNum + ", id=" + id + ", reviewContent=" + reviewContent + ", reviewDate="
				+ reviewDate + ", toString()=" + super.toString() + "]";
	}
	
	

}

