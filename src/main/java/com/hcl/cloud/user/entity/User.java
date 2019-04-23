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
	/**
	 * userAddress.
	 */
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
	 * Default constructor.
	 */
	public User() {
	}

	/**
	 *
	 * @return the id.
	 */
	public final long getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 *            the id to set.
	 */

	public final void setId(final long id) {
		this.id = id;
	}

	/**
	 *
	 * @return tag for userAddress.
	 */
	public final Set<Address> getUserAddress() {
		return userAddress;
	}

	/**
	 *
	 * @param userAddress
	 *            the userAddress to set.
	 */
	public final void setUserAddress(final Set<Address> userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 *
	 * @return tag for role.
	 */
	public final String getRole() {
		return role;
	}

	/**
	 *
	 * @param role
	 *            the role to set.
	 */
	@Column(name = "role")
	public final void setRole(final String role) {
		this.role = role;
	}

	/**
	 *
	 * @return tag for userName.
	 */
	public final String getUserName() {
		return userName;
	}

	/**
	 *
	 * @param userName
	 *            the userName to set.
	 */

	public final void setUserName(final String userName) {
		this.userName = userName;
	}

	/**
	 *
	 * @return tag for email.
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 *
	 * @param email
	 *            the email to set.
	 */
	@Column(name = "email")
	public final void setEmail(final String email) {
		this.email = email;
	}

	/**
	 *
	 * @return tag for password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 *
	 * @param password
	 *            the password to set.
	 */
	@Column(name = "password")
	public final void setPassword(final String password) {
		this.password = password;
	}

	/**
	 *
	 * @return tag for active.
	 */
	public final Integer getActive() {
		return active;
	}

	/**
	 *
	 * @param active
	 *            the active to set.
	 */
	public void setActive(Integer active) {
		this.active = active;
	}

	/**
	 *
	 * @return tag isLoacked.
	 */
	public final boolean isLoacked() {
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
	 * @return tag isExpired.
	 */
	public final boolean isExpired() {
		return isExpired;
	}

	/**
	 *
	 * @param isExpired
	 *            the isExpired to set.
	 */
	public final void setExpired(final boolean isExpired) {
		this.isExpired = isExpired;
	}

	/**
	 *
	 * @return tag isEnabled.
	 */
	public final boolean isEnabled() {
		return isEnabled;
	}

	/**
	 *
	 * @param isEnabled
	 *            the isEnabled to set.
	 */
	public final void setEnabled(final boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 *
	 * @return tag firstName.
	 */
	public final String getFirstName() {
		return firstName;
	}

	/**
	 *
	 * @param firstName
	 *            the firstName to set.
	 */
	public final void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 *
	 * @return tag lastName.
	 */
	public final String getLastName() {
		return lastName;
	}

	/**
	 *
	 * @param lastName
	 *            the lastName to set.
	 */
	public final void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 *
	 * @return tag phoneNumber.
	 */
	public final long getPhoneNumber() {
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
