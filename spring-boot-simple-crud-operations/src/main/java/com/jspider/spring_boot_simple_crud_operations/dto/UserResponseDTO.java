package com.jspider.spring_boot_simple_crud_operations.dto;

import java.util.Set;

import com.jspider.spring_boot_simple_crud_operations.entity.Role;

import lombok.Data;

@Data
public class UserResponseDTO {

	private Integer id;
	private String name;
	private String email;
	private Set<Role> roleName;

	public void SetRoleName(Set<Role> roles) {
		this.roleName = roles;
	}
}