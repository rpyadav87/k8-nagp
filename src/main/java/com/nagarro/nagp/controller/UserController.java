package com.nagarro.nagp.controller;

import com.nagarro.nagp.dto.UserDetailDto;
import com.nagarro.nagp.dto.UserDto;
import com.nagarro.nagp.dto.UserResponseDto;
import com.nagarro.nagp.service.UserService;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class UserController {

  /**
   * Instance of UserService
   */
  @Autowired
  private UserService userService;

  /**
   * Ths endpoint is used to check application health status
   * @return string health status of application
   */
  @GetMapping(path = "/health")
  public String getHealthStatus() {
    return "Running Docker K8 application.";

  }

  /**
   * This endpoint is used to insert user record.
   * @param userDto - UserDto object
   * @return String - insertion message.
   */
  @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> createUser(@Valid @RequestBody UserDto userDto) {
    log.info("Received user creation request for : {}", userDto.getFirstName());
    userService.createUser(userDto);
    return ResponseEntity.ok("User created successfully.");
  }

  /**
   * This method is used to get existing users.
   * @return UserResponseDto - have list of users
   */
  @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserResponseDto> getUsers() {
    return ResponseEntity.ok(userService.getUsers());
  }

  /**
   * This method is used to fetch the details of given user.
   * @param userId - requested user
   * @return UserDetailDto - details of given userId
   */
  @GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserDetailDto> getUserById(@PathVariable String userId) {
    log.info("Fetching details for user: {}", userId);
    return ResponseEntity.ok(userService.getUserById(userId));

  }


}
