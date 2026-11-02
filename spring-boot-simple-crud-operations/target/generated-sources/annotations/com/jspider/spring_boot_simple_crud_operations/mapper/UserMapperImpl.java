package com.jspider.spring_boot_simple_crud_operations.mapper;

import com.jspider.spring_boot_simple_crud_operations.dto.UserRequestDTO;
import com.jspider.spring_boot_simple_crud_operations.dto.UserResponseDTO;
import com.jspider.spring_boot_simple_crud_operations.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-27T00:33:06+0530",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( requestDTO.email() );
        user.setName( requestDTO.name() );
        user.setPassword( requestDTO.password() );

        return user;
    }

    @Override
    public UserResponseDTO toUserResponseDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setEmail( user.getEmail() );
        userResponseDTO.setId( user.getId() );
        userResponseDTO.setName( user.getName() );

        return userResponseDTO;
    }
}
