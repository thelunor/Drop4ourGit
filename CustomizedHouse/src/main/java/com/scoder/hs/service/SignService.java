package com.scoder.hs.service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface SignService extends UserDetailsService{
	public void genericUserSignUp();
	
}
