package com.scoder.hs.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "generic")
public class GenericEntity {
	
	@OneToOne(mappedBy = "reaEntity")
	private CHUserEntity chuserEntity;

    @Id
    private String userId;

    @Column(length = 30, nullable = false)
    private String birth;

    @Column(length = 30, nullable = false)
    private String resNum;

    @Column(length = 500, nullable = false)
    private String userAddress;

    @Column(length = 500, nullable = false)
    private String userDetailAddress;


    @Builder
    public GenericEntity(String userId, String resNum, String userAddress, String birth, String userDetailAddress) {
        this.userId = userId;
        this.birth = birth;
        this.resNum = resNum;
        this.userAddress = userAddress;
        this.userDetailAddress = userDetailAddress;
    }

}
