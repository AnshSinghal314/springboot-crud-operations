package com.jspider.spring_boot_simple_crud_operations.security_Config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jspider.spring_boot_simple_crud_operations.entity.User;
import com.jspider.spring_boot_simple_crud_operations.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(username).orElseThrow(()->new RuntimeException("user not found"));
		
		
		return org.springframework.security.core.userdetails.User
		.builder()
		.username(user.getEmail())
		.password(user.getPassword())
		.authorities(
				 user.getRoles().stream()
                 .map(role -> new SimpleGrantedAuthority(role.getName()))
                 .toList()	
		).build();
	}

}