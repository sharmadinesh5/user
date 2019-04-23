package com.hcl.cloud.user.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * com.hcl.cloud.user.DTO. abhishek_sin
 */
@JsonIgnoreProperties("id")
public class AddressDTO {
	/**
	 * id.
	 */
	private long id;
	/**
	 * address.
	 */
	private String address;
	/**
	 * city.
	 */
	private String city;
	/**
	 * country.
	 */
	private String country;
	/**
	 * state.
	 */
	private String state;
	/**
	 * pincode.
	 */
	private int pincode;
	/**
	 * addressType.
	 */
	private String addressType;

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
	public void setId(long id) {
		this.id = id;
	}

	/**
	 *
	 * @return the addressType.
	 */
	public final String getAddressType() {
		return addressType;
	}

	/**
	 *
	 * @param addressType
	 *            the addressType to set.
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 *
	 * @param pincode
	 *            the pincode to set.
	 */
	public final void setPincode(int pincode) {
		this.pincode = pincode;
	}

	/**
	 * Default constructor .
	 */
	public AddressDTO() {

	}

	/**
	 * @return the state.
	 */
	public final String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pin.
	 */
	public final int getPincode() {
		return pincode;
	}

	/**
	 * @param pin
	 *            the pin to set.
	 */
	public void setPinCode(int pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the address.
	 */
	public final String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city.
	 */
	public final String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country.
	 */
	public final String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

}
