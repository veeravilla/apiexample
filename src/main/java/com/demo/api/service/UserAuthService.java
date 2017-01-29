package com.demo.api.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {
	
	@Autowired
	private CustomerGrantedAuthority roleCustomer;
	
	@Autowired
	private AdminGrantedAuthority adminGrantedAuthority;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.equals("demoapi")) { // TODO : Access From DAO / External Server
			return new User(username, "Demo@123", getGrantedAuthorities(username));
		}
		throw new UsernameNotFoundException("Username " + username + " not found");
	}

	private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
		List<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>();
		roleList.add(roleCustomer);
		roleList.add(adminGrantedAuthority);
		return roleList;
	}
}
