package com.scoder.hs.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoder.hs.domain.entity.REAEntity;
import com.scoder.hs.domain.entity.ReaIntroBoardEntity;
import com.scoder.hs.dto.REA;
import com.scoder.hs.dto.REAIntroBoard;
import com.scoder.hs.dto.Sale;
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
	private SaleRepository saleRepository;
	
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

}
