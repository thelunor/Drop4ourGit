package kr.or.bit.dto;

import java.util.Date;

public class BookMark {
	private String id; //아이디 
	private String aptNum; //매물번호
	private Date bookDate; //북마크 등록 날짜
	
	public BookMark() {}
	
	public BookMark(String id, String aptNum, Date bookDate) {
		super();
		this.id = id;
		this.aptNum = aptNum;
		this.bookDate = bookDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAptNum() {
		return aptNum;
	}

	public void setAptNum(String aptNum) {
		this.aptNum = aptNum;
	}

	public Date getBookDate() {
		return bookDate;
	}

	public void setBookDate(Date bookDate) {
		this.bookDate = bookDate;
	}

	@Override
	public String toString() {
		return "BookMark [id=" + id + ", aptNum=" + aptNum + ", bookDate=" + bookDate + ", toString()="
				+ super.toString() + "]";
	} 
	
	
}
