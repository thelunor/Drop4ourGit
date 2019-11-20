package kr.or.bit.dto;

import java.util.Date;

public class ReviewComment {	//후기댓글 DTO
	private int comNum;		//후기 댓글 번호
	private String comContent;	//후기 내용
	private Date comDate;		//후기 작성날짜
	private String reaId;			//중개사 아이디
	private int reviewNum;		//후기 번호
	private String userId;			//후기 작성자 아이디
	
	public ReviewComment() {}

	public ReviewComment(int comNum, String comContent, Date comDate, String reaId, int reviewNum, String userId) {
		super();
		this.comNum = comNum;
		this.comContent = comContent;
		this.comDate = comDate;
		this.reaId = reaId;
		this.reviewNum = reviewNum;
		this.userId = userId;
	}

	public int getComNum() {
		return comNum;
	}

	public void setComNum(int comNum) {
		this.comNum = comNum;
	}

	public String getComContent() {
		return comContent;
	}

	public void setComContent(String comContent) {
		this.comContent = comContent;
	}

	public Date getComDate() {
		return comDate;
	}

	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}

	public String getReaId() {
		return reaId;
	}

	public void setReaId(String reaId) {
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

	@Override
	public String toString() {
		return "ReviewComment [comNum=" + comNum + ", comContent=" + comContent + ", comDate=" + comDate + ", reaId="
				+ reaId + ", reviewNum=" + reviewNum + ", userId=" + userId + ", toString()=" + super.toString() + "]";
	}


	
	
}
