/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.cloud.user.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByEmail(String email);

	public String deleteByUserName(String username);

	@Query("SELECT U.role FROM User U  WHERE U.email= (:email_id)")
	public String findUserRoleById(@Param("email_id") String email_id);

}
