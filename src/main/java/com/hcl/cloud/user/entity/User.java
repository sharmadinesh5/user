/**
 *
 */
package com.hcl.cloud.user.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author abhishek_sin
 *
 */
@Entity
@Table(name = "USER")
public class User {
	/**
	 * Id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	/**
	 * userId.
	 */
	@Column(name = "userId")
	private String userName;
	/**
	 * email.
	 */
	@Column(name = "email", unique = true)
	private String email;
	/**
	 * firstName.
	 */
	private String firstName;
	/**
	 * lastName.
	 */
	private String lastName;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<Address> userAddress = new HashSet<>();
	/**
	 * password.
	 */
	private String password;
	/**
	 * phoneNumber.
	 */
	private long phoneNumber;
	/**
	 * role.
	 */
	private String role;
	/**
	 * active.
	 */
	private Integer active = 1;
	/**
	 * isLoacked.
	 */
	private boolean isLoacked = false;
	/**
	 * isExpired.
	 */
	private boolean isExpired = false;
	/**
	 * isEnabled.
	 */
	private boolean isEnabled = true;

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
	 * @param id
	 *            the id to set
	 */

	public void setId(long id) {
		this.id = id;
	}

	/**
	 *
	 * @return the userAddress
	 */
	public Set<Address> getUserAddress() {
		return userAddress;
	}

	/**
	 *
	 * @param userAddress
	 *            the userAddress to set
	 */
	public void setUserAddress(Set<Address> userAddress) {
		this.userAddress = userAddress;
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
	 * @param role
	 *            the role to set
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
	 * @param userName
	 *            the userName to set
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
	 *
	 * /**
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
	 * @return the active.
	 */
	public Integer getActive() {
		return active;
	}

	/**
	 *
	 * @param active.
	 *            the active to set.
	 */
	public void setActive(Integer active) {
		this.active = active;
	}

	/**
	 *
	 * @return the isLoacked.
	 */
	public boolean isLoacked() {
		return isLoacked;
	}

	/**
	 *
	 * @param isLoacked
	 *            the isLoacked to set.
	 */
	public void setLoacked(boolean isLoacked) {
		this.isLoacked = isLoacked;
	}

	/**
	 *
	 * @return the isExpired.
	 */
	public boolean isExpired() {
		return isExpired;
	}

	/**
	 *
	 * @param isExpired
	 *            the isExpired to set.
	 */
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	/**
	 *
	 * @return the isEnabled.
	 */
	public boolean isEnabled() {
		return isEnabled;
	}

	/**
	 *
	 * @param isEnabled
	 *            the isEnabled to set.
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 *
	 * @return the firstName.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 *
	 * @param firstName
	 *            the firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 *
	 * @return the lastName.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 *
	 * @param lastName
	 *            the lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 *
	 * @return the phoneNumber.
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 *
	 * @param phoneNumber
	 *            the phoneNumber to set.
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
