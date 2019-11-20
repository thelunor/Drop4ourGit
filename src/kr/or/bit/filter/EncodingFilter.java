package kr.or.bit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
//@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

	// 변수 생성
	private String encoding;

	public EncodingFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	
	 * filterChain : 함수끼리 연결되어 있음. 필터를 여러개 만들면 여러개의 필터를 자전거 체인처럼 연결함.
	 * chain.doFilter를 기준으로  앞에 들어가는 건 request(요청이 들어올 때 걸러내는 거), 뒤에 들어가는 건 response(응답할 때 걸러내는 거)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//request : 요청이 왔을 때 구현되는 보조(공통) 관심
		if(request.getCharacterEncoding() == null) {
			System.out.println("before : "+request.getCharacterEncoding()); //그냥 확인용
			
			request.setCharacterEncoding(this.encoding); //이걸 통해서 모든 요청에 대해 이 필터가 동작함!
			
			System.out.println("after : "+request.getCharacterEncoding()); //그냥 확인용

		}
		chain.doFilter(request, response);
		
		//response : 응답할 때 구현되는 코드 
		
		System.out.println("");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 요청에 대해 최초 컴파일 될 때 실행되는 함수가 init 함수(최초 한번만 실행됨)
		/*
		web.xml 파일
		<init-param> 
		<param-name>encoding</param-name>
		<param-value>UTF-8</param-value> 
		</init-param>
		 * 
		 */
		this.encoding = fConfig.getInitParameter("encoding"); 
		//web.xml에 있는 param-name을 파라미터로 넣어서 value값을 가져올 수 있음 >> UTF-8을 가져옴
		System.out.println("Filter init : "+this.encoding);
	}

}
