package com.scoder.hs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.scoder.hs.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Override
	public void configure(WebSecurity web) {
		// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}
	
	/*
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/").permitAll()
        	.and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and();
    }
    */
	
	/*
	 HttpSecurity : HTTP 요청에 대한 웹 기반 보안을 구성
	 
	 */

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
	        // 페이지 권한 설정
				/*
				 * .antMatchers("/admin/**").hasRole("ADMIN")
				 * .antMatchers("/user/myinfo").hasRole("MEMBER")
				 */
	        
	        .antMatchers("/user/**")
	        .permitAll()
        .and() // 로그인 설정
	        .formLogin()
	        .loginPage("/user/login")
	        .defaultSuccessUrl("/user/login/result")
	        .permitAll()
        .and() // 로그아웃 설정
	        .logout()
	        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
	        .logoutSuccessUrl("/user/logout/result")
	        .invalidateHttpSession(true)
        .and()
	        // 403 예외처리 핸들링
	        .exceptionHandling().accessDeniedPage("/user/denied");
    }
	
	@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
	

}
