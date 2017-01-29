package com.demo.api.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class AdminGrantedAuthority implements GrantedAuthority{

	@Override
	public String getAuthority() {
		return "ROLE_ADMIN";
	}

}
