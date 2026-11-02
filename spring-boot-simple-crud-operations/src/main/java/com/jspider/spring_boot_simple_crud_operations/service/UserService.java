package com.jspider.spring_boot_simple_crud_operations.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jspider.spring_boot_simple_crud_operations.dto.UserRequestDTO;
import com.jspider.spring_boot_simple_crud_operations.dto.UserResponseDTO;
import com.jspider.spring_boot_simple_crud_operations.entity.Role;
import com.jspider.spring_boot_simple_crud_operations.entity.User;
import com.jspider.spring_boot_simple_crud_operations.mapper.UserMapper;
import com.jspider.spring_boot_simple_crud_operations.repository.RoleRepository;
import com.jspider.spring_boot_simple_crud_operations.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository repository;
	
	private final UserMapper mapper;
	
	private final PasswordEncoder encoder;
	
	private final RoleRepository roleRepository;
	
	@Transactional
	public UserResponseDTO saveUser(@RequestBody UserRequestDTO dto) {
		
		Set<Role> roles = new HashSet<>(); 
		
		Role role  = roleRepository.findByName(dto.roleName()).orElseThrow(() ->  new RuntimeException("user role has not found"));
		
		roles.add(role);
		
		User user = mapper.toUser(dto);
		
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRoles(roles);
		
		repository.save(user);
		
		UserResponseDTO responseDTO = mapper.toUserResponseDTO(user);
		responseDTO.SetRoleName(roles);
		
		return responseDTO;
		
	}
	
}
