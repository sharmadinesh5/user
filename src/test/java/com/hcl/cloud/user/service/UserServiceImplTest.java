/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.hcl.cloud.user.DTO.AddressDTO;
import com.hcl.cloud.user.DTO.UserDTO;
import com.hcl.cloud.user.constant.UserConstantTest;
import com.hcl.cloud.user.entity.Address;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.repository.UserRepository;
import com.hcl.cloud.user.service.impl.UserServiceImpl;

/**
 * com.user.usermodule.service abhishek_sin
 */
@PrepareForTest({ UserServiceImpl.class, User.class, Address.class, AddressDTO.class, UserDTO.class })
@RunWith(PowerMockRunner.class)
public class UserServiceImplTest {

	/**
	 * USER Mock
	 */
	@Mock
	private User userMock;
	/**
	 * userRepository
	 */
	@Mock
	private UserRepository userRepositoryMock;
	/**
	 * ModelMapper
	 */
	@Mock
	private ModelMapper modelMapperMock;

	/**
	 * Mock Object for {@link UserServiceImpl}
	 */
	@InjectMocks
	private UserServiceImpl userServiceImplMock;

	/**
	 * This Method is called before the test is executed.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		modelMapperMock = new ModelMapper();
		this.userServiceImplMock = Mockito.spy(new UserServiceImpl());
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * saveUserdetailsTest
	 */
	@Test
	public void saveUserdetailsSuccessTest() {
		AddressDTO addressDTOMock = PowerMockito.mock(AddressDTO.class);
		UserDTO userDTOMock = PowerMockito.mock(UserDTO.class);
		Mockito.when(addressDTOMock.getAddress()).thenReturn(UserConstantTest.ADDRESS);
		Mockito.when(addressDTOMock.getCity()).thenReturn(UserConstantTest.CITY);
		Mockito.when(addressDTOMock.getCountry()).thenReturn(UserConstantTest.COUNTRY);
		Mockito.when(addressDTOMock.getPincode()).thenReturn(UserConstantTest.PINCODE);
		Mockito.when(addressDTOMock.getState()).thenReturn(UserConstantTest.STATE);
		Mockito.when(addressDTOMock.getAddressType()).thenReturn(UserConstantTest.BILLING);
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddress(UserConstantTest.ADDRESS);
		addressDTO.setCity(UserConstantTest.CITY);
		addressDTO.setCountry(UserConstantTest.COUNTRY);
		addressDTO.setPincode(UserConstantTest.PINCODE);
		addressDTO.setState(UserConstantTest.STATE);
		addressDTO.setAddressType(UserConstantTest.BILLING);
		UserDTO userDTO = new UserDTO();
		List<AddressDTO> addDTOList = new ArrayList<>();
		addDTOList.add(addressDTO);
		userDTO.setFirstName(UserConstantTest.FIRSTNAME);
		userDTO.setLastName(UserConstantTest.LASTNAME);
		userDTO.setPassword(UserConstantTest.PASSWORD);
		userDTO.setPhoneNumber(UserConstantTest.PHONENUMBAR);
		userDTO.setUserName(UserConstantTest.USERNAME);
		userDTO.setEmail(UserConstantTest.EMAIL);
		// userDTO.setActive_user(true);
		userDTO.setUserAddress(addDTOList);

		Mockito.when(userDTOMock.getUserName()).thenReturn(UserConstantTest.USERNAME);
		Mockito.when(userDTOMock.getEmail()).thenReturn(UserConstantTest.EMAIL);
		Mockito.when(userDTOMock.getUserAddress()).thenReturn(addDTOList);
		Mockito.when(userDTOMock.getFirstName()).thenReturn(UserConstantTest.FIRSTNAME);
		Mockito.when(userDTOMock.getLastName()).thenReturn(UserConstantTest.LASTNAME);
		Mockito.when(userRepositoryMock.save(userMock)).thenReturn(userMock);
		Mockito.when(modelMapperMock.map(userMock, UserDTO.class)).thenReturn(userDTOMock);
		Mockito.when(userDTOMock.getUserAddress()).thenReturn(addDTOList);
		userServiceImplMock.saveUser(userDTO);
	}

	/**
	 * saveUserdetailsFailTest
	 */

	@Test
	public void saveUserdetailsFailTest() {
		AddressDTO addressDTOMock = PowerMockito.mock(AddressDTO.class);
		UserDTO userDTOMock = PowerMockito.mock(UserDTO.class);
		Mockito.when(addressDTOMock.getAddress()).thenReturn(UserConstantTest.ADDRESS);
		Mockito.when(addressDTOMock.getCity()).thenReturn(UserConstantTest.CITY);
		Mockito.when(addressDTOMock.getCountry()).thenReturn(UserConstantTest.COUNTRY);
		Mockito.when(addressDTOMock.getPincode()).thenReturn(UserConstantTest.PINCODE);
		Mockito.when(addressDTOMock.getState()).thenReturn(UserConstantTest.STATE);
		Mockito.when(addressDTOMock.getAddressType()).thenReturn(UserConstantTest.BILLING);
		AddressDTO addressDTO = new AddressDTO();
		UserDTO userDTO = new UserDTO();
		List<AddressDTO> addDTOList = new ArrayList<>();
		addDTOList.add(addressDTO);
		userDTO.setUserAddress(addDTOList);
		Mockito.when(userDTOMock.getEmail()).thenReturn(UserConstantTest.EMAIL);
		Mockito.when(userDTOMock.getUserAddress()).thenReturn(addDTOList);
		Mockito.when(userDTOMock.getFirstName()).thenReturn(UserConstantTest.FIRSTNAME);
		Mockito.when(userDTOMock.getLastName()).thenReturn(UserConstantTest.LASTNAME);
		Mockito.when(userRepositoryMock.save(userMock)).thenReturn(userMock);
		Mockito.when(modelMapperMock.map(userMock, UserDTO.class)).thenReturn(userDTOMock);
		Mockito.when(userDTOMock.getUserAddress()).thenReturn(addDTOList);
		userServiceImplMock.saveUser(userDTO);
	}

	/**
	 * updateUserdetailsTest
	 */

	@Test
	public void updateUserdetailsTest() {
		AddressDTO addressDTOMock = PowerMockito.mock(AddressDTO.class);
		UserDTO userDTOMock = PowerMockito.mock(UserDTO.class);
		List<AddressDTO> addDTOList = new ArrayList<>();
		addDTOList.add(addressDTOMock);
		UserDTO userDTO = new UserDTO();
		userDTO.setFirstName(UserConstantTest.FIRSTNAME);
		userDTO.setLastName(UserConstantTest.LASTNAME);
		userDTO.setPassword(UserConstantTest.PASSWORD);
		userDTO.setPhoneNumber(UserConstantTest.PHONENUMBAR);
		userDTO.setUserName(UserConstantTest.USERNAME);
		userDTO.setEmail(UserConstantTest.EMAIL);
		Mockito.when(addressDTOMock.getAddress()).thenReturn(UserConstantTest.ADDRESS);
		Mockito.when(addressDTOMock.getCity()).thenReturn(UserConstantTest.CITY);
		Mockito.when(addressDTOMock.getCountry()).thenReturn(UserConstantTest.COUNTRY);
		Mockito.when(addressDTOMock.getPincode()).thenReturn(UserConstantTest.PINCODE);
		Mockito.when(addressDTOMock.getState()).thenReturn(UserConstantTest.STATE);
		Mockito.when(userDTOMock.getUserName()).thenReturn(UserConstantTest.USERNAME);
		Mockito.when(userDTOMock.getEmail()).thenReturn(UserConstantTest.EMAIL);
		Mockito.when(userDTOMock.getUserAddress()).thenReturn(addDTOList);
		Mockito.when(userDTOMock.getFirstName()).thenReturn(UserConstantTest.FIRSTNAME);
		Mockito.when(userDTOMock.getLastName()).thenReturn(UserConstantTest.LASTNAME);
		Mockito.when(userRepositoryMock.save(userMock)).thenReturn(userMock);
		Mockito.when(modelMapperMock.map(userMock, UserDTO.class)).thenReturn(userDTOMock);
		userServiceImplMock.updateUser(userDTO);
	}

	/**
	 * deleteUserdetailsTest
	 */
	@Test
	public void deleteUserdetailsTest() {
		Mockito.when(userRepositoryMock.save(userMock)).thenReturn(userMock);
		Mockito.when(userRepositoryMock.findByEmail(UserConstantTest.EMAIL)).thenReturn(userMock);
		userServiceImplMock.deleteUser(UserConstantTest.USERNAME);
	}

	/**
	 * deleteUserdetailsFailTest
	 */
	@Test
	public void deleteUserdetailsFailTest() {
		userServiceImplMock.deleteUser(UserConstantTest.USERNAME);
	}

	/**
	 * findUserRoleByID
	 */
	@Test
	public void findUserRoleByIDTest() {
		List<User> userList = new ArrayList<>();
		User user = new User();
		user.setFirstName(UserConstantTest.FIRSTNAME);
		user.setLastName(UserConstantTest.LASTNAME);
		user.setPassword(UserConstantTest.PASSWORD);
		user.setPhoneNumber(UserConstantTest.PHONENUMBAR);
		user.setUserName(UserConstantTest.USERNAME);
		user.setEmail(UserConstantTest.EMAIL);
		userList.add(user);
		Mockito.when(userRepositoryMock.findByEmail(UserConstantTest.USERID)).thenReturn(user);
		Mockito.when(userRepositoryMock.findAll()).thenReturn(userList);
		Mockito.when(userRepositoryMock.findUserRoleById(UserConstantTest.USERID)).thenReturn(UserConstantTest.USERID);
		userServiceImplMock.findUserRoleByID(UserConstantTest.AUTHTOKEN);
	}
}
