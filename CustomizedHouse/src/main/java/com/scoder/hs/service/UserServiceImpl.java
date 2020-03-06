package com.scoder.hs.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scoder.hs.dto.User;
import com.scoder.hs.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//DAO를 이용해서 계정을 가져와서 반환해줌
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("넘어오는 값?"+userName);
		
		User user = userRepository.findById(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		System.out.println("유저?"+user.toString());
		
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
        		
		return new org.springframework.security.core.userdetails.User(user.getUserId(), 
                user.getUserPwd(),
                authorities);
	}
}
