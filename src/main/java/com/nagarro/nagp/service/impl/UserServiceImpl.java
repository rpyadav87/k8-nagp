package com.nagarro.nagp.service.impl;

import com.nagarro.nagp.dto.UserDetailDto;
import com.nagarro.nagp.dto.UserDto;
import com.nagarro.nagp.dto.UserResponseDto;
import com.nagarro.nagp.entity.User;
import com.nagarro.nagp.repository.UserRepository;
import com.nagarro.nagp.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class performs the user specific operation and interacts to database.
 */
@Service
@Slf4j
@NoArgsConstructor
public class UserServiceImpl implements UserService {

  /**
   * Instance of UserRepository
   */
  @Autowired
  private UserRepository userRepository;

  /**
   * This endpoint is used to insert user record into database.
   * @param userDto - UserDto object
   * @return String - insertion message.
   */
  @Override
  @Transactional
  public void createUser(UserDto userDto) {
    User user = new User();
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setEmail(userDto.getEmail());
    userRepository.save(user);
  }


  /**
   * This method is used to get existing users from database.
   * @return UserResponseDto - have list of users
   */
  @Override
  public UserResponseDto getUsers() {
    List<User> usersList = userRepository.findAll();
    UserResponseDto userResponseDto = new UserResponseDto();
    List<UserDetailDto> userDetailDtoList = new ArrayList<>();
    for (User user : usersList) {
      UserDetailDto userDetailDto = new UserDetailDto();
      userDetailDto.setUserId(user.getUserId());
      userDetailDto.setFirstName(user.getFirstName());
      userDetailDto.setLastName(user.getLastName());
      userDetailDto.setEmail(user.getEmail());
      userDetailDtoList.add(userDetailDto);
    }
    userResponseDto.setUsers(userDetailDtoList);
    return userResponseDto;
  }

  /**
   * This method is used to fetch the details of given user from database.
   * @param userId - requested user
   * @return UserDetailDto - details of given userId
   */
  @Override
  @Transactional
  public UserDetailDto getUserById(String userId) {
    User user = userRepository.findByUserId(Short.valueOf(userId));
    UserDetailDto userDetailDto = new UserDetailDto();
    if(!Objects.isNull(user)){
      userDetailDto.setUserId(user.getUserId());
      userDetailDto.setFirstName(user.getFirstName());
      userDetailDto.setLastName(user.getLastName());
      userDetailDto.setEmail(user.getEmail());
    }
    return userDetailDto;
  }
}
