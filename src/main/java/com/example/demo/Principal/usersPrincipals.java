package com.example.demo.Principal;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.models.Users;

public class usersPrincipals implements UserDetails {

	private int id;
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public usersPrincipals(int id, String username, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static usersPrincipals build(Users user) {
		 List<GrantedAuthority> authorities = user.getRoles().stream()
	                .map(role -> new SimpleGrantedAuthority(role.getRole()))
	                .collect(Collectors.toList());
		return new usersPrincipals(
				user.getId(),
				user.getUsername(),
				user.getPassword(),
				authorities);
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities; 
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}



	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
