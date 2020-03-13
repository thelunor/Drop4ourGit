package com.scoder.hs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scoder.hs.domain.entity.CHUserEntity;
import com.scoder.hs.domain.entity.UserRoleListEntity;
import com.scoder.hs.dto.CHUserCustom;
import com.scoder.hs.dto.Role;
import com.scoder.hs.repository.RoleRepository;
import com.scoder.hs.repository.UserRepository;


@Service
public class SignServiceImpl implements SignService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	boolean enabled = true;
	boolean accountNonExpired = true;
	boolean credentialsNonExpired = true;
	boolean accountNonLocked = true;
	
	
	@Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<CHUserEntity> userEntityWrapper = userRepository.findById(userId);
        CHUserEntity userEntity = userEntityWrapper.get();
        Optional<UserRoleListEntity> roleEntityWrapper = roleRepository.findRoleNameByUserId(userId);
        UserRoleListEntity roleEntity = roleEntityWrapper.get();
        
        System.out.println("유저 정보 가져오니?"+userEntity.toString());
        System.out.println("롤 정보 가져오니?"+roleEntity.toString());
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        if(roleEntity.getRoleName().equals("ROLE_ADMIN")) {
        	authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else if (roleEntity.getRoleName().equals("ROLE_GENUSER")) {
        	authorities.add(new SimpleGrantedAuthority(Role.GENUSER.getValue()));
        } else if (roleEntity.getRoleName().equals("ROLE_REAUSER")) {
        	authorities.add(new SimpleGrantedAuthority(Role.REAUSER.getValue()));
        }
        
        CHUserCustom chuserCustom = new CHUserCustom(userEntity.getUserId(), userEntity.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, 
        		userEntity.getUserName(), userEntity.getUserPhoneNum(), userEntity.getIsLock(), userEntity.getLoginCnt(), userEntity.getUserMail());
                
        return chuserCustom;
    }
	
	
}
