package com.scoder.hs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoder.hs.domain.entity.REAEntity;
import com.scoder.hs.dto.REA;
import com.scoder.hs.repository.REARepository;

@Service
public class REAService {
	
	@Autowired
	private REARepository reaRepository;
	
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
		System.out.println("값 객체로 됨?"+rea.toString());
		return rea;
	}

}
