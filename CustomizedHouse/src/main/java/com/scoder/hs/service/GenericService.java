package com.scoder.hs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scoder.hs.domain.entity.GenericEntity;
import com.scoder.hs.dto.Generic;
import com.scoder.hs.repository.GenericRepository;

@Service
public class GenericService {
	
	@Autowired
	private GenericRepository genericRepository;
	
	//정보 가져오기
	public Generic getGenericInfo (String userId) {
		System.out.println("서비스 타냐?"+userId);
		Optional<GenericEntity> genericEntityWrapper = genericRepository.findById(userId);
		//genericRepository.findOne(example);
		GenericEntity genericEntity = genericEntityWrapper.get();
		System.out.println("db에서 가져온 정보?"+genericEntity.toString());
		Generic generic = Generic.builder()
							.userId(genericEntity.getUserId())
							.birth(genericEntity.getBirth())
							.resNum(genericEntity.getResNum())
							.userAddress(genericEntity.getUserAddress())
							.userDetailAddress(genericEntity.getUserDetailAddress())
							.build();
		return generic;
	}

}
