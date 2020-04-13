package com.scoder.hs.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scoder.hs.domain.entity.CHUserEntity;
import com.scoder.hs.domain.entity.GenericEntity;
import com.scoder.hs.dto.CHUser;
import com.scoder.hs.dto.Generic;
import com.scoder.hs.repository.CHUserRepository;
import com.scoder.hs.repository.GenericRepository;

@Service
public class CHUserService {

    @Autowired
    private CHUserRepository chUserRepository;


    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    /**
     * 일반회원 마이페이지 화면에 보일 기본 정보 가져오기
     * @author 이정은
     * @since 2020/03/24
     * @param userId
     * @return chUser
     */
    public CHUser getCHUserInfo (String userId) {
        Optional<CHUserEntity> chUserEntityWrapper = chUserRepository.findById(userId);
        CHUserEntity chUserEntity = chUserEntityWrapper.get();
        CHUser chUser = CHUser.builder()
                .userId(chUserEntity.getUserId())
                .userName(chUserEntity.getUserName())
                .userEmail(chUserEntity.getUserEmail())
                .userPhoneNum(chUserEntity.getUserPhoneNum())
                .build();
        return chUser;
    }



    //암호화
    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }

}
