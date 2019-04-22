/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.cloud.user.DTO.UserDTO;
import com.hcl.cloud.user.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByUserName(String username);

	public String deleteByUserName(String username);

	@Query("SELECT U.role FROM User U  WHERE U.userName= (:user_id)")
	public String findUserRoleById(@Param("user_id") String user_id);

	@Query("SELECT U FROM User U  WHERE U.userName= (:user_id)")
	public User findUserDetailsByID(@Param("user_id") String user_id);

}
