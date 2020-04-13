package com.scoder.hs.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name = "reaIntroBoard")
public class ReaIntroBoardEntity {
	
	@Id
	private String userId;
	@Column(length = 500, nullable = false)
	private String introTitle;
	@Column(length = 3000, nullable = false)
	private String introContent;
	
	@Builder
	public ReaIntroBoardEntity(String userId, String introTitle, String introContent) {
		this.userId = userId;
		this.introTitle = introTitle;
		this.introContent = introContent;
	}
	
	
}
