package com.nkh.usermanagement.service.Impl;

import com.nkh.usermanagement.entity.User;
import com.nkh.usermanagement.repository.UserRepo;
import com.nkh.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepo.getUserById(id);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Ko co user co id nay");
        }
        return userOptional.get();
    }
}
