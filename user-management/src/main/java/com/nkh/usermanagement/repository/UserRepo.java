package com.nkh.usermanagement.repository;

import com.nkh.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
