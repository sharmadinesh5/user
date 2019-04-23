/**
 * 
 */
package com.hcl.cloud.user.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import com.hcl.cloud.user.DTO.UserDTO;
import com.hcl.cloud.user.constant.UserConstantTest;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.service.UserService;

/**
 * @author abhishek_sin
 *
 */
@PrepareForTest(UserController.class)
@RunWith(value = PowerMockRunner.class)
public class UserControllerTest {

	/**
	 * UserDTO
	 */
	@Mock
	private UserDTO userDTOMock;
	/**
	 * List<UserDTO> userDetails
	 */
	@Mock
	private List<UserDTO> userDetailsMock;

	/**
	 * User
	 */
	@Mock
	private User userMock;
	/**
	 * userService
	 */
	@Mock
	private UserService userServiceMock;
	/**
	 * Mock Object for {@link UserController}
	 */
	@InjectMocks
	private UserController userControllerMock;

	/**
	 * This Method is called before the test is executed.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.userControllerMock = Mockito.spy(new UserController());
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * saveUserDetailsTest
	 */
	@Test
	public void saveUserDetailsTest() {
		Mockito.when(userServiceMock.saveUser(userDTOMock)).thenReturn(userMock);
		userControllerMock.saveUserDetails(userDTOMock, UserConstantTest.AUTH_TOKEN);
	}

	/**
	 * saveUserDetailsTest
	 */
	@Test
	public void getAllUserDetailsTest() {
		Mockito.when(userServiceMock.findUserRoleByID(UserConstantTest.AUTH_TOKEN)).thenReturn(userDetailsMock);
		userControllerMock.getAllUserDetails(UserConstantTest.AUTH_TOKEN);
	}

	/**
	 * saveUserDetailsTest
	 */
	@Test
	public void deleteUserDetailsByIDTest() {
		Mockito.when(userServiceMock.deleteUser(UserConstantTest.USER_ID)).thenReturn(null);
		userControllerMock.deleteUserDetailsByID(UserConstantTest.USER_ID, UserConstantTest.AUTH_TOKEN);
	}

	/**
	 * saveUserDetailsTest
	 */
	@Test
	public void updateUserDetailsTest() {
		Mockito.when(userServiceMock.findUserRoleByID(UserConstantTest.AUTH_TOKEN)).thenReturn(userDetailsMock);
		userControllerMock.updateUserDetails(userDTOMock, UserConstantTest.AUTH_TOKEN);
	}
}
