/**
 * 
 */
package com.hcl.cloud.user.service;

import com.hcl.cloud.user.DTO.UserDTO;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.exception.ExceptionHandler;


/**
 * @author abhishek_sin
 *
 */
public interface UserService {

		public Iterable<UserDTO> findAllUser();
	    public User saveUser(UserDTO user);
	    public User updateUser(UserDTO userDTO) ;
	    public String deleteUser(String userId );
	    public UserDTO findUserById(String userId);
}
