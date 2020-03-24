package com.scoder.hs.dto;

import com.scoder.hs.domain.entity.ReaIntroBoardEntity;

import lombok.Builder;
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
	
	public ReaIntroBoardEntity toEntity() {
		ReaIntroBoardEntity reaIntroBoardEntity = ReaIntroBoardEntity.builder()
				.userId(userId)
				.introTitle(introTitle)
				.introContent(introContent)
				.build();
		return reaIntroBoardEntity;
	}

	@Builder
	public REAIntroBoard(String userId, String introTitle, String introContent) {
		this.userId = userId;
		this.introTitle = introTitle;
		this.introContent = introContent;
		
	}
	
	

}
