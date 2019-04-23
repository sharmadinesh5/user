/**
 * 
 */
package com.hcl.cloud.user.service;

import java.util.List;

import com.hcl.cloud.user.DTO.UserDTO;
import com.hcl.cloud.user.entity.User;

/**
 * @author abhishek_sin
 *
 */
public interface UserService {

	public Iterable<UserDTO> findAllUser();

	public User findUserDetailsByID(String userID);

	public User saveUser(UserDTO user);

	public User updateUser(UserDTO userDTO);

	public String deleteUser(String userId);

	public List<UserDTO> findUserRoleByID(String accessToken);
}
