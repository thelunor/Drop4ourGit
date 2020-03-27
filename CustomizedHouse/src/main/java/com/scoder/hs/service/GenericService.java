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
public class GenericService {
	
	@Autowired
	private CHUserRepository chUserRepository;
	
	@Autowired
	private GenericRepository genericRepository;
	
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	

	/**
	 * 회원 정보 수정에 필요한 정보 가져오기
	 * @author 이정은
	 * @since 2020/03/24 
	 * @param userId
	 * @return generic
	 */
	public Generic getUserDetailInfo (String userId) {
		Optional<GenericEntity> genericEntityWrapper = genericRepository.findById(userId);
		GenericEntity genericEntity = genericEntityWrapper.get();		
		Generic generic = Generic.builder()
							.userId(genericEntity.getUserId())
							.birth(genericEntity.getBirth())
							.resNum(genericEntity.getResNum())
							.userAddress(genericEntity.getUserAddress())
							.userDetailAddress(genericEntity.getUserDetailAddress())
							.build();
		return generic;
		
	}
	
		/**
		 * 회원정보 데이터 수정
		 * @author 이정은
		 * @since 2020/03/26 
		 * @param chUser
		 * @param generic
		 * @param userId
		 * @return result
		 */
	    @Transactional
		public boolean EditGenericUser(CHUser chUser, Generic generic, String userId) {
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
				Optional<GenericEntity> genericEntityWrapper = genericRepository.findById(userId);
				genericEntityWrapper.ifPresent(genericUser ->{
					genericUser.setBirth(generic.getBirth());
					genericUser.setResNum(generic.getResNum());
					genericUser.setUserAddress(generic.getUserAddress());
					genericUser.setUserDetailAddress(generic.getUserDetailAddress());
					GenericEntity newGeneric = genericRepository.save(genericUser);
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
