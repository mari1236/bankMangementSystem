package com.example.demo.securityConfiguration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.jWUtils.TokenUtils;
import com.example.demo.service.MyService;
@Component
public class firstFilter extends OncePerRequestFilter {

	@Autowired
	private TokenUtils token;
	
	@Autowired
	private MyService myService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header=request.getHeader("Authorization");
		String username=null;
		String jwtToken=null;
		
		if(header!=null && header.startsWith("Bearer "))
		{
			jwtToken=header.substring(7);
			try {
				
				username=this.token.extractUsername(jwtToken);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
		UserDetails userDetails=this.myService.loadUserByUsername(username);
		//Security
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
			authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
