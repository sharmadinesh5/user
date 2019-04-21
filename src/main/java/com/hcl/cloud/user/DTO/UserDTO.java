package com.hcl.cloud.user.DTO;

import java.util.List;

public class UserDTO {
	private long id;
	private String userName;
	private String email;
	private String first_name;
	private String last_name;
	private List<AddressDTO> user_address;
	private String password;
	private long phone_number;
	private boolean active_user;

	/**
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 *
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}


	
	/**
	 *
	 * @param id
	 * @param userName
	 * @param email
	 * @param first_name
	 * @param last_name
	 * @param user_address
	 * @param password
	 * @param phone_number
	 * @param active_user
	 */
	public UserDTO(long id, String userName, String email, String first_name, String last_name,
			List<AddressDTO> user_address, String password, long phone_number, boolean active_user) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.user_address = user_address;
		this.password = password;
		this.phone_number = phone_number;
		this.active_user = active_user;
	}

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 *
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 *
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name
	 *            the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name
	 *            the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the user_address
	 */
	public List<AddressDTO> getUser_address() {
		return user_address;
	}

	/**
	 * @param user_address
	 *            the user_address to set
	 */
	public void setUser_address(List<AddressDTO> user_address) {
		this.user_address = user_address;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phone_number
	 */
	public long getPhone_number() {
		return phone_number;
	}

	/**
	 * @param phone_number
	 *            the phone_number to set
	 */
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * @return the active_user
	 */
	public boolean isActive_user() {
		return active_user;
	}

	/**
	 * @param active_user
	 *            the active_user to set
	 */
	public void setActive_user(boolean active_user) {
		this.active_user = active_user;
	}

}
