package com.jspider.spring_boot_simple_crud_operations.controller;
import com.jspider.spring_boot_simple_crud_operations.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.spring_boot_simple_crud_operations.dto.UserLoginDTO;
import com.jspider.spring_boot_simple_crud_operations.dto.UserLoginResponceDTO;
import com.jspider.spring_boot_simple_crud_operations.dto.UserRequestDTO;
import com.jspider.spring_boot_simple_crud_operations.dto.UserResponseDTO;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController{
	
    private final UserService userService;
    
    private final AuthenticationManager authenticationManager;
    
    private final SecurityContextRepository contextRepository;
	
	@PostMapping(value= "/register")
	public UserResponseDTO register(@RequestBody UserRequestDTO userRequestDTO) {
		
		return userService.saveUser(userRequestDTO);
	}
	

	/**
	 * @param loginDTO
	 * @param request
	 * @param response
	 * @return
	 */
	
	@PostMapping(value = "/login")
	public ResponseEntity<UserLoginResponceDTO> login(@RequestBody UserLoginDTO loginDTO , HttpServletRequest request , HttpServletResponse response) {
		
		//it is like a form or application for login containing your email and password;
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.email() , loginDTO.password());
		
		//checks the credentials;
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		
		
//		 Authentication authentication;
//		    try {
//		        authentication = authenticationManager.authenticate(authenticationToken);
//		    } catch (org.springframework.security.core.AuthenticationException ex) {
//		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//		                .body(new UserLoginResponceDTO("Invalid email or password", null, null));
//		    }
		
		
		//creates the empty box for the valid user details;
		SecurityContext securityContext  = SecurityContextHolder.createEmptyContext();
		
		//store the details of the verified user;
		securityContext.setAuthentication(authentication);
		
		//ye bata han spring security ko ki valid user ye ha;
		SecurityContextHolder.setContext(securityContext);
		
		//make it avaliable for the whole session;
		contextRepository.saveContext(securityContext, request, response);
		
		String email = authentication.getName();
		
		List<String> roles = authentication.getAuthorities().stream().map(i -> i.getAuthority()).toList();
		
		UserLoginResponceDTO loginResponceDTO = new UserLoginResponceDTO("Login succesfull" , email , roles);
		return  ResponseEntity.status(HttpStatus.OK).body(loginResponceDTO) ;
	}
	
}
