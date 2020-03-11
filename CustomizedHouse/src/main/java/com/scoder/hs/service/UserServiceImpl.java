package com.scoder.hs.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scoder.hs.domain.Role;
import com.scoder.hs.domain.entity.CHUserEntity;
import com.scoder.hs.dto.CHUser;
import com.scoder.hs.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<CHUserEntity> userEntityWrapper = userRepository.findById(userId);
        CHUserEntity userEntity = userEntityWrapper.get();
        System.out.println("디비에서 가져온 유저 정보?"+userEntity.toString());
        
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("admin@example.com").equals(userId)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User(userEntity.getUserId(), userEntity.getPassword(), authorities);
    }
	
	
}
