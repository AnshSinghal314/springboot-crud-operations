package com.jspider.spring_boot_simple_crud_operations.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.jspider.spring_boot_simple_crud_operations.entity.Role;
import com.jspider.spring_boot_simple_crud_operations.repository.RoleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleService implements CommandLineRunner{

	private final RoleRepository repository;

	@Override
	public void run(String... args) throws Exception {
		
		Role role1 = new Role();
		role1.setName("EMPLOYEE");
		
		Role role2 = new Role();
		role2.setName("CUSTOMER");
		
		Role role3 = new Role();
		role3.setName("GUEST");
		
		List<Role> roles = new ArrayList<>();
		roles.add(role1) ; roles.add(role2); roles.add(role3);
		
		for(Role role : roles) {
			if( repository.findByName(role.getName()).isPresent()) {
				
			}else {
				repository.save(role);
			}
		}
	}
	
	
}
