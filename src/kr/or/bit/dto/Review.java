package kr.or.bit.dto;

import java.util.Date;

public class Review {				//후기 DTO
	private int reviewNum;			//후기 번호
	private String userId;			//후기 작성자 아이디
	private String reviewContent;	//후기 내용
	private Date reviewDate;		//후기 작성 시간
	private String reaId;			//공인중개사 아이디
	
	public Review() {}
	
	public Review(int reviewNum, String userId, String reviewContent, Date reviewDate, String reaId) {
		super();
		this.reviewNum = reviewNum;
		this.userId = userId;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.reaId = reaId;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getReaid() {
		return reaId;
	}

	public void setReaid(String reaId) {
		this.reaId = reaId;
	}

	@Override
	public String toString() {
		return "Review [reviewNum=" + reviewNum + ", userId=" + userId + ", reviewContent=" + reviewContent
				+ ", reviewDate=" + reviewDate + ", reaId=" + reaId + "]";
	}

}

