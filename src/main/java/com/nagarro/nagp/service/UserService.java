package com.nagarro.nagp.service;

import com.nagarro.nagp.dto.UserDetailDto;
import com.nagarro.nagp.dto.UserDto;
import com.nagarro.nagp.dto.UserResponseDto;

public interface UserService {

  /**
   * This endpoint is used to insert user record.
   * @param userDto - UserDto object
   * @return String - insertion message.
   */
  void createUser(UserDto userDto);

  /**
   * This method is used to get existing users.
   * @return UserResponseDto - have list of users
   */
  UserResponseDto getUsers();

  /**
   * This method is used to fetch the details of given user.
   * @param userId - requested user
   * @return UserDetailDto - details of given userId
   */
  UserDetailDto getUserById(String userId);
}
