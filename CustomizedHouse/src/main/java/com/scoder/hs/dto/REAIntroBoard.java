package com.scoder.hs.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
public class REAIntroBoard { //중개인 게시판
	
	private String userId;
	private String introTitle;
	private String introContent;

}
