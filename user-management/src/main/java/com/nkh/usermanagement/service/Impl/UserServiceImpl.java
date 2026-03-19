package com.nkh.usermanagement.service.Impl;

import com.nkh.usermanagement.entity.User;
import com.nkh.usermanagement.repository.UserRepo;
import com.nkh.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}
