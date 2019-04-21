/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.cloud.user.DTO.AddressDTO;
import com.hcl.cloud.user.DTO.UserDTO;
import com.hcl.cloud.user.entity.Address;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.repository.UserRepository;
import com.hcl.cloud.user.service.UserService;


/**
 * 
 * TODO
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	ModelMapper mapper = null;		

	/**
	 *
	 * @return
	 */
	@Override
	public Iterable<UserDTO> findAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 * @param user
	 * @return
	 */
	@Override
	@Transactional
	public User saveUser(UserDTO userDTO) {
		User user =new User();
		//mapper = new ModelMapper();
		if (userDTO!=null) {
		//User userentity = mapper.map(user, User.class);	
		user=translateDTO(userDTO, user);
		User response = userRepository.save(user);
		//responsedto = mapper.map(response, UserDTO.class);
		} 
		
		return user;
	}
	
	
//	Query query = new Query(Criteria.where("user_name").is(userDTO.getUser_name()));


	/**
	 *
	 * @param userDTO
	 * @throws NotFoundException 
	 */
	@Override
	public User updateUser(UserDTO userDTO) {
		User user = userRepository.findByUserName(userDTO.getUserName());
		if(user!=null) {
		translateDTO(userDTO,user);
		user = userRepository.save(user);
		}
		
		return user;
		
	}
	
	public User translateDTO(UserDTO userDTO,User user) {
		user.setUserName(userDTO.getUserName());
		user.setEmail(userDTO.getEmail());
		user.setFirst_name(userDTO.getFirst_name());
		user.setLast_name(userDTO.getLast_name());
		user.setPhone_number(userDTO.getPhone_number());
		user.setUser_address(translateAddressDTO(userDTO.getUser_address()));
		user.setPassword(userDTO.getPassword());
		return user;
	}
	
	
	public List<Address> translateAddressDTO( List<AddressDTO> addressDto) {
		List<Address> addressList = new ArrayList<>();
		Address address = new Address();
		for (AddressDTO addr : addressDto) {
			address.setAddressDescription(addr.getAddress());
			address.setAddressType(addr.getAddressType());
			address.setCity(addr.getCity());
			address.setPincode(addr.getPincode());
			address.setCountry(addr.getCountry());
			address.setState(addr.getState());
			addressList.add(address);
		}
		return addressList;
	}

	/**
	 *
	 * @param userId
	 */
	@Override
	public String deleteUser(String userId) {
		User user = userRepository.findByUserName(userId);
		if(user!=null) {
			user.setActive_user(false);
		 userRepository.save(user);
		}
		return "delete successfully";
	}

	/**
	 *
	 * @param userId
	 * @return
	 */
	@Override
	public UserDTO findUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
