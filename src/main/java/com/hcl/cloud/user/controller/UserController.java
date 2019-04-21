/**
 * 
 */
package com.hcl.cloud.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.cloud.user.DTO.AddressDTO;
import com.hcl.cloud.user.DTO.UserDTO;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.exception.ExceptionHandler;
import com.hcl.cloud.user.service.UserService;


/**
 * @author abhishek_sin
 *
 */
@RestController
@RequestMapping(value = "/api/user-management/")
public class UserController {

	@Autowired
	public UserService userService;

	/**
	 * 
	 *
	 * @param user
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ResponseEntity<User> saveUserDetails(@RequestBody UserDTO user) {
	/*	AddressDTO address = new AddressDTO();
		List<AddressDTO> list = new ArrayList<>();
		address.setAddress("Sector 126");
		address.setCity("Noida");
		address.setState("U.P");
		address.setCountry("India");
		address.setPinCode(201303);
		list.add(address);
		user.setUser_address(list);*/
		User userDetails=userService.saveUser(user);
		return new ResponseEntity<>(userDetails, HttpStatus.OK);
	}

	/**
	 * updateUserDetails method are updating user details
	 *
	 * @param user
	 * @return
	 * @throws NotFoundException 
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUserDetails(@RequestBody UserDTO user) {
	userService.updateUser(user);
		System.out.println("updateUserDetails : " + user);
		return new ResponseEntity<>("Successfully updated ", HttpStatus.OK);
	}

	/**
	 * getAllUserDetails method are fetching all user details
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/viewuserDetail", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getAllUserDetails() {
		return null;
	}

	/**
	 * getUserDetailsByID method are fetching user details by user ID
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/getUserDetailsByID/{userid}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUserDetailsByID(@PathVariable("userid") String userid) {
		UserDTO userDTO = new UserDTO();
		AddressDTO address = new AddressDTO();
		List<AddressDTO> list = new ArrayList<>();
		list.add(address);
	//	userDTO.setUser_name("abhishek2067");
		userDTO.setEmail("abhishek@hcl.com");
		userDTO.setPassword("**********");
		userDTO.setFirst_name("Abhi");
		userDTO.setLast_name("Singh");
		address.setAddress("Sector 126");
		address.setCity("Noida");
		address.setState("U.P");
		address.setCountry("India");
		address.setPinCode(201303);
		userDTO.setPhone_number(9594806263l);
		userDTO.setUser_address(list);
		// userService.updateUser();
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}

	/**
	 * deleteUserDetailsByID method are soft deleting user details Change the user
	 * active flag are false after delete operation
	 * 
	 * @param userID
	 * @return
	 */
	@RequestMapping(value = "/deleteuser/{userid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUserDetailsByID(@PathVariable("userid") String userid) {
		String message = null;
		message = userService.deleteUser(userid);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
