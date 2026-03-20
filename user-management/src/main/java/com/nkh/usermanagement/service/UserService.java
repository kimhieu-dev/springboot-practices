package com.nkh.usermanagement.service;

import com.nkh.usermanagement.dto.request.UserReq;
import com.nkh.usermanagement.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    User getUserById(Long id);

    User createUser(UserReq request);
}
