package com.scoder.hs.domain.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name = "reaimage")
public class REAImageEntity {
    @OneToOne(mappedBy = "reaImageEntity")
    private CHUserEntity chuserEntity;

    @Id
    private String userId;

    @Column(length = 500, nullable = false)
    private String reaImageName;

    @Builder
    public REAImageEntity(String userId, String reaImageName) {
        this.userId = userId;
        this.reaImageName = reaImageName;
    }
}
