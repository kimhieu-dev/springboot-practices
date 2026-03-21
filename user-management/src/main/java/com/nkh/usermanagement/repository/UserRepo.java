package com.nkh.usermanagement.repository;

import com.nkh.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String userName);
}
