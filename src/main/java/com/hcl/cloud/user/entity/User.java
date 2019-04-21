/**
 * 
 */
package com.hcl.cloud.user.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import com.hcl.cloud.user.DTO.Role;


/**
 * @author abhishek_sin
 *
 */
@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long id;
	@Column(name = "userName" , unique=true)
	private String userName;
	private String email;
	private String first_name;
	private String last_name;
	@OneToMany(mappedBy="userAddress", cascade = CascadeType.ALL)
	private List<Address> user_address;
	private String password;
	private long phone_number;
	private boolean active_user = true;
	private String role;
	
	/**
	 * Default constructor
	 */
	public User() {
	}





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
	 * @return the user_address
	 */
	public List<Address> getUser_address() {
		return user_address;
	}


	/**
	 *
	 * @param user_address the user_address to set
	 */
	public void setUser_address(List<Address> user_address) {
		this.user_address = user_address;
	}


	/**
	 *
	 * @return the role
	 */
	public String getRole() {
		return role;
	}


	/**
	 *
	 * @param role the role to set
	 */
	@Column(name = "role")
	public void setRole(String role) {
		this.role = role;
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
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 *
	 * @param email
	 *            the email to set
	 */
	@Column(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 *
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 *
	 * @param first_name
	 *            the first_name to set
	 */
	@Column(name = "first_name")
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 *
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 *
	 * @param last_name
	 *            the last_name to set
	 */
	@Column(name = "lat_name")
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *
	 * @param password
	 *            the password to set
	 */
	@Column(name = "password")
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 *
	 * @return the phone_number
	 */
	public long getPhone_number() {
		return phone_number;
	}

	/**
	 *
	 * @param phone_number
	 *            the phone_number to set
	 */
	@Column(name = "phone")
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 *
	 * @return the active_user
	 */
	public boolean isActive_user() {
		return active_user;
	}

	/**
	 *
	 * @param active_user
	 *            the active_user to set
	 */
	@Column(name = "status")
	public void setActive_user(boolean active_user) {
		this.active_user = active_user;
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
	 * @param role
	 */
	public User(long id, String userName, String email, String first_name, String last_name, List<Address> user_address,
			String password, long phone_number, boolean active_user, String role) {
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
		this.role = role;
	}

	
	
}
