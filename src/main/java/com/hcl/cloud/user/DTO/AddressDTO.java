package com.hcl.cloud.user.DTO;

public class AddressDTO {
	private long id;
	private String address;
	private String city;
	private String country;
	private String state;
	private int pincode;
	private String addressType;

		
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
	 * @return the addressType
	 */
	public String getAddressType() {
		return addressType;
	}

	/**
	 *
	 * @param addressType the addressType to set
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 *
	 * @param pincode the pincode to set
	 */
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	/**
	 * Default constructor 
	 */
	public AddressDTO() {
		
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the pin
	 */
	public int getPincode() {
		return pincode;
	}

	/**
	 * @param pin
	 *            the pin to set
	 */
	public void setPinCode(int pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	

}
