/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.cloud.user.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByUserName(String username);
	public String deleteByUserName(String username);
	
}
