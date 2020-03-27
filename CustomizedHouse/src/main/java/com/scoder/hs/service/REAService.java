package com.scoder.hs.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.scoder.hs.domain.entity.CHUserEntity;
import com.scoder.hs.domain.entity.GenericEntity;
import com.scoder.hs.domain.entity.REAEntity;
import com.scoder.hs.domain.entity.ReaIntroBoardEntity;
import com.scoder.hs.dto.CHUser;
import com.scoder.hs.dto.Generic;
import com.scoder.hs.dto.REA;
import com.scoder.hs.dto.REAIntroBoard;
import com.scoder.hs.dto.Sale;
import com.scoder.hs.repository.CHUserRepository;
import com.scoder.hs.repository.REARepository;
import com.scoder.hs.repository.ReaIntroBoardRepository;
import com.scoder.hs.repository.SaleRepository;

@Service
public class REAService {
	
	@Autowired
	private REARepository reaRepository;
	
	@Autowired
	private ReaIntroBoardRepository reaIntroBoardRepository;
	
	@Autowired
	private CHUserRepository chUserRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	//공인중개사 회원 정보 가져오기
	public REA getReaInfo(String userId) {
		Optional<REAEntity> reaEntityWrapper = reaRepository.findById(userId);
		REAEntity reaEntity = reaEntityWrapper.get();
		REA rea = REA.builder()
				.userId(reaEntity.getUserId())
				.reaNum(reaEntity.getReaNum())
				.officeName(reaEntity.getOfficeName())
				.officeAddress(reaEntity.getOfficeAddress())
				.officePhoneNum(reaEntity.getOfficePhoneNum())
				.build();
		return rea;
	}
	
	//공인중개사 소개글 쓰기
	@Transactional
	public boolean saveReaIntro(REAIntroBoard reaIntroBoard) {
		boolean result = false;
		try {
			reaIntroBoardRepository.save(reaIntroBoard.toEntity()).getUserId();
			result = true;
		} catch(Exception e) {
			System.out.println("saveReaIntro Service Error"+e.getMessage());
		}
		return result;
	}
	
	//공인중개사 소개글 가져오기
	public REAIntroBoard getReaIntro(String userId) {
		REAIntroBoard reaIntroBoard = null;
		Optional<ReaIntroBoardEntity> reaIntroBoardWrapper = reaIntroBoardRepository.findByUserId(userId);
		if(reaIntroBoardWrapper.isPresent()) {
			ReaIntroBoardEntity reaIntroBoardEntity = reaIntroBoardWrapper.get();
			System.out.println("엔티티 가져와?"+reaIntroBoardEntity);
			reaIntroBoard = REAIntroBoard.builder()
											.userId(reaIntroBoardEntity.getUserId())
											.introTitle(reaIntroBoardEntity.getIntroTitle())
											.introContent(reaIntroBoardEntity.getIntroContent())
											.build();
		}
		
		System.out.println("소개글 dto?"+reaIntroBoard);
		
		return reaIntroBoard;
	}
	
	//매물 등록
	@Transactional
	public boolean saveSale(Sale sale) {
		System.out.println("매물 서비스 탄다!"+sale.toEntity());
		boolean result = false;
		try {
			Long saleNum = saleRepository.save(sale.toEntity()).getSaleNum();
			System.out.println("매물 번호?"+saleNum);
			result = true;
		} catch(Exception e) {
			System.out.println("saveSale Service Error"+e.getMessage());
		}
		return result;
	}

	/**
	 * 공인중개사 정보 데이터 수정
	 * @author 이정은
	 * @since 2020/03/26  
	 * @param chUser
	 * @param rea
	 * @param userId
	 * @return result
	 */
    @Transactional
	public boolean EditREAUser(CHUser chUser, REA rea, String userId) {
		boolean result = false;
		try {
			String encodedPassword = new BCryptPasswordEncoder().encode(chUser.getPassword());
			Optional<CHUserEntity> chUserEntityWrapper = chUserRepository.findById(userId);
			chUserEntityWrapper.ifPresent(user ->{
				user.setPassword(encodedPassword);
				user.setUserName(chUser.getUserName());
				user.setUserEmail(chUser.getUserEmail());
				user.setUserPhoneNum(chUser.getUserPhoneNum());
				CHUserEntity newUser = chUserRepository.save(user);
	           });
			Optional<REAEntity> reaEntityWrapper = reaRepository.findById(userId);
			reaEntityWrapper.ifPresent(reaUser ->{
				reaUser.setOfficeName(rea.getOfficeName());
				reaUser.setOfficeAddress(rea.getOfficeAddress());
				reaUser.setOfficePhoneNum(rea.getOfficePhoneNum());
				reaUser.setReaNum(rea.getReaNum());				
				REAEntity newREA = reaRepository.save(reaUser);
			});
			result = true;
		} catch (Exception e) {
			System.out.println("SignService signUpGenericUser 예외발생: " + e.getMessage());
		}
		return result;
	}
	
	//암호화
	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}
}
