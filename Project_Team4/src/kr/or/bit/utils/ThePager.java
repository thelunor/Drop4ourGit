package kr.or.bit.utils;

public class ThePager {

	private int pageSize;// 한 페이지당 데이터 개수
	private int pagerSize;// 번호로 보여주는 페이지 Link 개수
	private int dataCount;// 총 데이터 수
	private int currentPage;// 현재 페이지 번호
	private int pageCount;// 총 페이지 수
	private String type;

	private String linkUrl;// 페이저가 포함되는 페이지의 주소

	public ThePager(int dataCount, int currentPage, int pageSize, int pagerSize, String linkUrl, String type) {

		this.linkUrl = linkUrl;

		this.dataCount = dataCount;
		this.pageSize = pageSize;
		this.pagerSize = pagerSize;
		this.currentPage = currentPage;
		pageCount = (dataCount / pageSize) + ((dataCount % pageSize) > 0 ? 1 : 0);
		this.type = type;
	}

	public String toString() {
		StringBuffer linkString = new StringBuffer();

		// 1. 처음, 이전 항목 만들기
		if (currentPage > 1) {
			linkString.append(String.format("[<a href='%s&type=%s&cp=1'>처음</a>]", linkUrl,type));
			linkString.append("&nbsp;");
			linkString.append("&nbsp;");
			linkString.append(String.format("[<a href='%s&type=%s&cp=%d'>이전</a>]", linkUrl,type, currentPage - 1));
			linkString.append("&nbsp;");
		}

		// 2. 페이지 번호 Link 만들기
		int pagerBlock = (currentPage - 1) / pagerSize;
		int start = (pagerBlock * pagerSize) + 1;
		int end = start + pagerSize;
		for (int i = start; i < end; i++) {
			if (i > pageCount)
				break;
			linkString.append("&nbsp;");
			if (i == currentPage) {
				linkString.append(String.format("[%d]", i));
			} else {
				linkString.append(String.format("<a href='%s&type=%s&cp=%d'>%d</a>", linkUrl,type, i, i));
			}
			linkString.append("&nbsp;");
		}

		// 3. 다음, 마지막 항목 만들기
		if (currentPage < pageCount) {
			linkString.append(String.format("[<a href='%s&type=%s&cp=%d'>다음</a>]", linkUrl,type, currentPage + 1));
			linkString.append("&nbsp;");
			linkString.append("&nbsp;");
			linkString.append(String.format("[<a href='%s&type=%s&cp=%d'>마지막</a>]", linkUrl,type,pageCount));
			linkString.append("&nbsp;");
		}

		return linkString.toString();
	}

}