package kr.or.bit.dto;

import java.util.Date;

public class REASchedule { //공인중개사 매물 일정 관리
	private int scheNum; //일정번호
	private Date scheDate; //일정 날짜
	private String aptNum; //매물 번호
	private String subject; //제목
	private String content; //내용
	
	public REASchedule() {}

	public REASchedule(int scheNum, Date scheDate, String aptNum, String subject, String content) {
		super();
		this.scheNum = scheNum;
		this.scheDate = scheDate;
		this.aptNum = aptNum;
		this.subject = subject;
		this.content = content;
	}

	public int getScheNum() {
		return scheNum;
	}

	public void setScheNum(int scheNum) {
		this.scheNum = scheNum;
	}

	public Date getScheDate() {
		return scheDate;
	}

	public void setScheDate(Date scheDate) {
		this.scheDate = scheDate;
	}

	public String getAptNum() {
		return aptNum;
	}

	public void setAptNum(String aptNum) {
		this.aptNum = aptNum;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "REASchedule [scheNum=" + scheNum + ", scheDate=" + scheDate + ", aptNum=" + aptNum + ", subject="
				+ subject + ", content=" + content + ", toString()=" + super.toString() + "]";
	}
	
	
}
