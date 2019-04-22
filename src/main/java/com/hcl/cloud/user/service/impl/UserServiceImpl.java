/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.hcl.cloud.user.DTO.AddressDTO;
import com.hcl.cloud.user.DTO.UserDTO;
import com.hcl.cloud.user.constant.UserConstant;
import com.hcl.cloud.user.entity.Address;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.exception.ExceptionHandler;
import com.hcl.cloud.user.repository.UserRepository;
import com.hcl.cloud.user.service.UserService;

/**
 * UserServiceImpl TODO
 */
@Service
public class UserServiceImpl implements UserService {
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	ModelMapper mapper = null;

	/**
	 *
	 * @return
	 */
	@Override
	public Iterable<UserDTO> findAllUser() {
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
		User user = new User();
		if (userDTO != null) {
			LOG.debug("userDTO details: "+userDTO);
			user = translateDTO(userDTO, user);
			userRepository.save(user);
		}
		return user;
	}

	/**
	 *
	 * @param userDTO
	 * @throws NotFoundException
	 */
	@Override
	public User updateUser(UserDTO userDTO) {
		User user = userRepository.findByUserName(userDTO.getUserName());
		if (user != null) {
			LOG.debug("userDTO details: "+userDTO);
			translateDTO(userDTO, user);
			user = userRepository.save(user);
		}
		return user;
	}

	/**
	 * 
	 * translateDTO
	 * 
	 * @param userDTO
	 * @param user
	 * @return
	 */
	public User translateDTO(UserDTO userDTO, User user) {
		LOG.debug("Enter translateDTO method: "+userDTO);
		user.setUserName(userDTO.getUserName());
		user.setEmail(userDTO.getEmail());
		user.setFirst_name(userDTO.getFirst_name());
		user.setLast_name(userDTO.getLast_name());
		user.setPhone_number(userDTO.getPhone_number());
		user.setUser_address(translateAddressDTO(userDTO.getUser_address()));
		user.setPassword(userDTO.getPassword());
		return user;
	}
	
	/**
	 * 
	 * translateDTO
	 * 
	 * @param userDTO
	 * @param user
	 * @return
	 */
	public List<UserDTO> translateUserDetails(List<User> users) {
		LOG.debug("Enter translateDTO method: "+users);
		UserDTO dto=new UserDTO();
		List<UserDTO>  userDTOs=new ArrayList<>();		
		for(User user:users) {
			dto.setUserName(user.getUserName());
			dto.setEmail(user.getEmail());
			dto.setFirst_name(user.getFirst_name());
			dto.setLast_name(user.getLast_name());
			dto.setPhone_number(user.getPhone_number());
			dto.setUser_address(translateAddress(user.getUser_address()));
			dto.setPassword(user.getPassword());
		userDTOs.add(dto);
	}
		return userDTOs;
		}

	/**
	 * 
	 * translate Address DTO
	 * 
	 * @param addressDto
	 * @return
	 */
	public List<Address> translateAddressDTO(List<AddressDTO> addressDto) {
		List<Address> addressList = new ArrayList<>();
		LOG.debug("Enter translateAddressDTO method and addressDto: "+addressDto);
		for (AddressDTO addr : addressDto) {
			Address address = new Address();
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
	 * translate Address DTO
	 * 
	 * @param addressDto
	 * @return
	 */
	public List<AddressDTO> translateAddress(List<Address> address) {
		List<AddressDTO> addressList = new ArrayList<>();
		AddressDTO addressDto = new AddressDTO();
		LOG.debug("Enter translateAddressDTO method and addressDto: "+addressDto);
		for (Address addr : address) {
			addressDto.setAddress(addr.getAddressDescription());
			addressDto.setAddressType(addr.getAddressType());
			addressDto.setCity(addr.getCity());
			addressDto.setPincode(addr.getPincode());
			addressDto.setCountry(addr.getCountry());
			addressDto.setState(addr.getState());
			addressList.add(addressDto);
		}
		return addressList;
	}

	/**
	 *
	 * @param userId
	 */
	@Override
	public String deleteUser(String userId) {
		LOG.debug("Enter deleteUser method and userId: "+userId);
		User user = userRepository.findByUserName(userId);
		if (user != null) {
			user.setActive_user(false);
			userRepository.save(user);
			LOG.debug("Updated active flag ");
		}
		return "delete successfully";
	}

	/**
	 *
	 * @param userId
	 * @return
	 */
	@Override
	@Transactional
	public List<UserDTO> findUserRoleByID(String accessToken) {
		User user=null;
		List<User> userList = new ArrayList<>();
		List<UserDTO> dtos = null;
		String userID=getUserIDFromAccessToken(accessToken);
		String userRole=userRepository.findUserRoleById(userID);
		LOG.error("@@@@ "+userRole);
		if(UserConstant.ADMIN_ROLE.equals(userRole)) {
			userList=userRepository.findAll();
			dtos=translateUserDetails(userList);
		}else if(UserConstant.USER_ROLE.equals(userRole)) {
			user=findUserDetailsByID(userID);
			userList.add(user);
			dtos=translateUserDetails(userList);
		}
		return dtos;
	}
	
	/**
	 * getUserIDFromAccessToken
	 */
	public String getUserIDFromAccessToken(String accessToken) {
		String userID="abhi2021";
		return userID;
		
	}
	/**
	 * 
	 *findUserDetailsByID
	 * @param userID
	 * @return
	 */
	@Override
	public User findUserDetailsByID(String userID) {
		return userRepository.findUserDetailsByID(userID);
	}

}
