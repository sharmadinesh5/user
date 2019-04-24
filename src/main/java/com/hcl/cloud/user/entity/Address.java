package com.hcl.cloud.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ADDRESS")
public class Address {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    /**
     * userAddress
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonIgnore
    private User userAddress;
    /**
     * addressDescription.
     */
    private String addressDescription;
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
     * @return the userAddress.
     */
    public final User getUserAddress() {
        return userAddress;
    }

    /**
     *
     * @param userAddress
     *            the userAddress to set.
     */
    public void setUserAddress(User userAddress) {
        this.userAddress = userAddress;
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

    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return the city.
     */
    public final String getCity() {
        return city;
    }

    /**
     *
     * @param city
     *            the city to set.
     */
    @Column(name = "city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return the addressDescription.
     */
    public final String getAddressDescription() {
        return addressDescription;
    }

    /**
     *
     * @param addressDescription
     *            the addressDescription to set.
     */
    @Column(name = "address")
    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    /**
     *
     * @return the country.
     */
    public final String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     *            the country to set.
     */
    @Column(name = "country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return the state.
     */
    public final String getState() {
        return state;
    }

    /**
     *
     * @param state
     *            the state to set.
     */
    @Column(name = "state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return the pincode.
     */
    public final int getPincode() {
        return pincode;
    }

    /**
     *
     * @param pincode
     *            the pincode to set.
     */
    @Column(name = "pincode")
    public void setPincode(int pincode) {
        this.pincode = pincode;
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
    @Column(name = "addressType")
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

}
