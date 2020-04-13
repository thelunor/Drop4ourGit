package com.scoder.hs.service;
import com.scoder.hs.domain.entity.CHUserEntity;
import com.scoder.hs.domain.entity.UserRoleListEntity;
import com.scoder.hs.dto.*;
import com.scoder.hs.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.File;
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
	private REARepository reaRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private REAImageRepository reaImageRepository;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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

		System.out.println("커스텀된 객체 만들기" + chuserCustom.getAuthorities());
		return chuserCustom;
	}



//	@Transactional
//	public String signUpCHuser(CHUser chUser) {
//		return chUserRepository.save(chUser.toEntity()).getUserId();
//	}

	//일반유저 회원가입
	@Transactional
	public boolean signUpGenericUser(CHUser chUser, Generic generic) {
		boolean result = false;
		System.out.println("수정---------------------");
		System.out.println(chUser.toString());
		try {
			String encodedPassword = new BCryptPasswordEncoder().encode(chUser.getPassword());
			chUser.setPassword(encodedPassword);
			chUserRepository.save(chUser.toEntity()).getUserId();
			genericRepository.save(generic.toEntity()).getUserId();
			result = true;
		} catch (Exception e) {
			System.out.println("SignService signUpGenericUser 예외발생: " + e.getMessage());
		}
		return result;
	}
	//공인중개사 회원가입
	@Transactional
	public boolean signUpREAUser(CHUser chUser, REA rea, REAImage reaImage, MultipartFile multipartFile, HttpServletRequest request) {
		boolean result = false;
		try {
			File dest = new File("C:/reaimage/" + multipartFile.getOriginalFilename());
			multipartFile.transferTo(dest);
			System.out.println("request.getContextPath()" + request.getContextPath());

			String encodedPassword = new BCryptPasswordEncoder().encode(chUser.getPassword());
			reaImage.setReaImageName(multipartFile.getOriginalFilename());
			chUser.setPassword(encodedPassword);
			chUserRepository.save(chUser.toEntity()).getUserId();
			reaRepository.save(rea.toEntity()).getUserId();

			reaImageRepository.save(reaImage.toEntity()).getUserId();
			result = true;
		} catch (Exception e) {
			System.out.println("SignService signUpREAUser 예외발생: " + e.getMessage());
		}
		return result;
	}

	//암호화
	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}
}