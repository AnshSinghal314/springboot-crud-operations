package com.jspider.spring_boot_simple_crud_operations.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspider.spring_boot_simple_crud_operations.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByName(String name);
	Optional<User> findByEmail(String email);
}
