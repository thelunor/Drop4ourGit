package com.scoder.hs.service;
import com.scoder.hs.domain.entity.CHUserEntity;
import com.scoder.hs.domain.entity.UserRoleListEntity;
import com.scoder.hs.dto.CHUser;
import com.scoder.hs.dto.CHUserCustom;
import com.scoder.hs.dto.Generic;
import com.scoder.hs.dto.Role;
import com.scoder.hs.repository.CHUserRepository;
import com.scoder.hs.repository.GenericRepository;
import com.scoder.hs.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SignService implements UserDetailsService {
	@Autowired
	private CHUserRepository chUserRepository;
	@Autowired
	private GenericRepository genericRepository;
	@Autowired
	private RoleRepository roleRepository;

	boolean enabled = true;
	boolean accountNonExpired = true;
	boolean credentialsNonExpired = true;
	boolean accountNonLocked = true;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		Optional<CHUserEntity> userEntityWrapper = chUserRepository.findById(userId);
		CHUserEntity userEntity = userEntityWrapper.get();
		Optional<UserRoleListEntity> roleEntityWrapper = roleRepository.findRoleNameByUserId(userId);
		UserRoleListEntity roleEntity = roleEntityWrapper.get();

		List<GrantedAuthority> authorities = new ArrayList<>();

		if(roleEntity.getRoleName().equals("ROLE_ADMIN")) {
			authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
		} else if (roleEntity.getRoleName().equals("ROLE_GENUSER")) {
			authorities.add(new SimpleGrantedAuthority(Role.GENUSER.getValue()));
		} else if (roleEntity.getRoleName().equals("ROLE_REAUSER")) {
			authorities.add(new SimpleGrantedAuthority(Role.REAUSER.getValue()));
		}

		CHUserCustom chuserCustom = new CHUserCustom(userEntity.getUserId(), userEntity.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities,
				userEntity.getUserName(), userEntity.getUserPhoneNum(), userEntity.getIsLock(), userEntity.getLoginCnt(), userEntity.getUserEmail());

		return chuserCustom;
	}



	@Transactional
	public String signUpCHuser(CHUser chUser) {
		System.out.println(chUserRepository.save(chUser.toEntity()).getUserId() + " chUserRepository.save(chUser.toEntity()).getUserId()");
		return chUserRepository.save(chUser.toEntity()).getUserId();
	}

	@Transactional
	public boolean signUpGenericUser(CHUser chUser, Generic generic) {
		boolean result = false;
		try {
			chUserRepository.save(chUser.toEntity()).getUserId();
			genericRepository.save(generic.toEntity()).getUserId();
			result = true;
		} catch (Exception e) {
			System.out.println("SignService signUpGenericUser 예외발생: " + e.getMessage());
		}
		return result;
	}
}