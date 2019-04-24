/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.hcl.cloud.user.DTO.AddressDTO;
import com.hcl.cloud.user.DTO.UserDTO;
import com.hcl.cloud.user.constant.UserConstant;
import com.hcl.cloud.user.entity.Address;
import com.hcl.cloud.user.entity.User;
import com.hcl.cloud.user.repository.UserRepository;
import com.hcl.cloud.user.service.UserService;;

/**
 * UserServiceImpl TODO
 */
@Service
public class UserServiceImpl implements UserService {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    ModelMapper mapper = null;

    /**
     *
     * @param user
     *            for save.
     * @return tag for user.
     */
    @Override
    @Transactional
    public User saveUser(UserDTO userDTO) {
        User user = new User();
        if (userDTO != null) {
            LOG.debug("userDTO details: " + userDTO);
            user = translateDTO(userDTO, user);
            user = userRepository.save(user);
        }
        return user;
    }

    /**
     *
     * @param userDTO
     *            for update user.
     * @throws NotFoundException
     */
    @Override
    public User updateUser(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if (user != null) {
            LOG.debug("userDTO details: " + userDTO);
            translateDTO(userDTO, user);
            user = userRepository.save(user);
        }
        return user;
    }

    /**
     *
     * translateDTO
     *
     * @param userDTO
     *            for translateDTO.
     * @param user
     *            for User.
     * @return tag for user.
     */
    public User translateDTO(UserDTO userDTO, User user) {
        LOG.debug("Enter translateDTO method: " + userDTO);
        final UUID uuid = UUID.randomUUID();
        user.setUserName(uuid.toString());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setEnabled(userDTO.isEnabled());
        user.setActive(userDTO.getActive());
        user.setExpired(userDTO.isExpired());
        user.setLoacked(userDTO.isLoacked());
        user.setRole(userDTO.getRole());
        final Set<Address> set = translateAddressDTO(userDTO.getUserAddress(), user);
        user.setPassword(userDTO.getPassword());
        user.setUserAddress(set);
        return user;
    }

    /**
     *
     * translateDTO
     *
     * @param userDTO
     *            for translateDTO.
     * @param user
     *            for List.
     * @return for user DTO.
     */
    public List<UserDTO> translateUserDetails(List<User> users) {
        LOG.debug("Enter translateDTO method: " + users);
        final UserDTO dto = new UserDTO();
        final List<UserDTO> userDTOs = new ArrayList<>();
        for (final User user : users) {
            dto.setUserName(user.getUserName());
            dto.setEmail(user.getEmail());
            dto.setFirstName(user.getFirstName());
            dto.setLastName(user.getLastName());
            dto.setPhoneNumber(user.getPhoneNumber());
            dto.setUserAddress(translateAddress(user.getUserAddress()));
            dto.setActive_user(user.isActive_user());
            dto.setPassword(user.getPassword());
            userDTOs.add(dto);
        }
        return userDTOs;
    }

    /**
     *
     * translate Address DTO
     *
     * @param addressDto
     *            translate Address DTO.
     * @return tag for address.
     */
    public Set<Address> translateAddressDTO(List<AddressDTO> addressDto, User user) {
        final Set<Address> addressSet = new HashSet<>();
        LOG.debug("Enter translateAddressDTO method and addressDto: " + addressDto);
        for (final AddressDTO addr : addressDto) {
            final Address address = new Address();
            address.setAddressDescription(addr.getAddress());
            address.setAddressType(addr.getAddressType());
            address.setCity(addr.getCity());
            address.setPincode(addr.getPincode());
            address.setCountry(addr.getCountry());
            address.setState(addr.getState());
            address.setUserAddress(user);
            addressSet.add(address);
        }

        return addressSet;
    }

    /**
     *
     * translate Address DTO
     *
     * @param addressDto
     *            translate Address.
     * @return tag for addressDTO.
     */
    public List<AddressDTO> translateAddress(Set<Address> address) {
        final List<AddressDTO> addressList = new ArrayList<>();
        final AddressDTO addressDto = new AddressDTO();
        LOG.debug("Enter translateAddressDTO method and addressDto: " + addressDto);
        for (final Address addr : address) {
            addressDto.setAddress(addr.getAddressDescription());
            addressDto.setAddressType(addr.getAddressType());
            addressDto.setCity(addr.getCity());
            addressDto.setPincode(addr.getPincode());
            addressDto.setCountry(addr.getCountry());
            addressDto.setState(addr.getState());
            addressList.add(addressDto);
        }
        return addressList;
    }

    /**
     *
     * @param userId
     *            for Delete user.
     */
    @Override
    public String deleteUser(String emailId) {
        LOG.debug("Enter deleteUser method and userId: " + emailId);
        final User user = userRepository.findByEmail(emailId);
        if (user != null) {
            userRepository.save(user);
            LOG.debug("Updated active flag ");
        }
        return "delete successfully";
    }

    /**
     *
     * @param userId
     *            for find user role by id.
     * @return tag for user DTO.
     */
    @Override
    @Transactional
    public List<UserDTO> findUserRoleByID(String accessToken) {
        User user = null;
        List<User> userList = new ArrayList<>();
        List<UserDTO> dtos = null;
        final String emailID = getUserIDFromAccessToken(accessToken);
        final String userRole = userRepository.findUserRoleById(emailID);
        if (UserConstant.ADMINROLE.equalsIgnoreCase(userRole)) {
            userList = userRepository.findAll();
            dtos = translateUserDetails(userList);
        } else if (UserConstant.USERROLE.equalsIgnoreCase(userRole)) {
            user = findUserDetailsByID(emailID);
            userList.add(user);
            dtos = translateUserDetails(userList);
        }
        return dtos;
    }

    /**
     * getUserIDFromAccessToken
     */
    public String getUserIDFromAccessToken(String accessToken) {
        final String userID = "dinesh@hcl.com";
        return userID;

    }

    /**
     *
     * findUserDetailsByID
     *
     * @param userID
     * @return
     */
    @Override
    public User findUserDetailsByID(String emailId) {
        return userRepository.findByEmail(emailId);
    }

}
