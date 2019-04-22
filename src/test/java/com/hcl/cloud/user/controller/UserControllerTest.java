/**
 * 
 */
package com.hcl.cloud.user.controller;

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
import com.hcl.cloud.user.constant.UserConstant;
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

	@Test
	public void saveUserDetailsTest() {
		Mockito.when(userServiceMock.saveUser(userDTOMock)).thenReturn(userMock);
		userControllerMock.saveUserDetails(userDTOMock,UserConstantTest.AUTH_TOKEN);
	}
}
