package com.nagarro.nagp.repository;

import com.nagarro.nagp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This class hold operation specific to User repository.
 */
public interface UserRepository extends JpaRepository<User, Short> {
  User findByUserId(Short id);
}
