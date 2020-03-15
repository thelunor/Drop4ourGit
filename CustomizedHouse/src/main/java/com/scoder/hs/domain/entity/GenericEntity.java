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
@Table(name = "rea")
public class GenericEntity {

    @Id
    private String userId;

    @Column(length = 30, nullable = false)
    private String birth;

    @Column(length = 30, nullable = false)
    private String resNum;

    @Column(length = 500, nullable = false)
    private String userAddress;


    @Builder
    public GenericEntity(String userId, String resNum, String userAddress, String birth) {
        this.userId = userId;
        this.birth = birth;
        this.resNum = resNum;
        this.userAddress = userAddress;
    }

}
