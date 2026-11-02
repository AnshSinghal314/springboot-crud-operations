package com.jspider.spring_boot_simple_crud_operations.mapper;

import org.mapstruct.Mapper;

import com.jspider.spring_boot_simple_crud_operations.dto.UserRequestDTO;
import com.jspider.spring_boot_simple_crud_operations.dto.UserResponseDTO;
import com.jspider.spring_boot_simple_crud_operations.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	User toUser(UserRequestDTO requestDTO);
	
	UserResponseDTO toUserResponseDTO(User user);

}
