package com.nkh.usermanagement.service.Impl;

import com.nkh.usermanagement.dto.request.UserReq;
import com.nkh.usermanagement.entity.User;
import com.nkh.usermanagement.repository.UserRepo;
import com.nkh.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Ko co user co id nay");
        }
        return userOptional.get();
    }

    @Override
    public User createUser(UserReq request) {
        //validate
        if (request.getUserName() == null || request.getUserName().isEmpty()) {
            throw new RuntimeException("username must be not null");
        }
        if (request.getFirstName() == null || request.getFirstName().isEmpty()) {
            throw new RuntimeException("firstname must be not null");
        }
        if (request.getLastName() == null || request.getLastName().isEmpty()) {
            throw new RuntimeException("lastname must be not null");
        }
        if (request.getAge() == null) {
            throw new RuntimeException("age must be not null");
        }
        //ten co the duplicate nhung username ko duoc duplicate
        if (userRepo.findByUserName((request.getUserName())).isPresent()){
            throw new RuntimeException("username exist");
        }
        User user = new User();
        user.setUserName(request.getUserName());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setAge(request.getAge());
        userRepo.save(user);
        return user;
    }

    @Override
    public User updateUser(Long id, UserReq request) {
        //validate
        Optional<User> userOptional = userRepo.findById(id);
        //kiem tra xem trong db co user nay chua
        if(userOptional.isEmpty()){
            throw new RuntimeException("Khong co user nao co id nay");
        }
        if (request.getUserName() == null || request.getUserName().isEmpty()) {
            throw new RuntimeException("username must be not null");
        }
        if (request.getFirstName() == null || request.getFirstName().isEmpty()) {
            throw new RuntimeException("firstname must be not null");
        }
        if (request.getLastName() == null || request.getLastName().isEmpty()) {
            throw new RuntimeException("lastname must be not null");
        }
        if (request.getAge() == null) {
            throw new RuntimeException("age must be not null");
        }
        //ten co the duplicate nhung username ko duoc duplicate
        if (userRepo.findByUserName(request.getUserName()).isPresent()){
            throw new RuntimeException("username exist");
        }
        userOptional.get().setUserName(request.getUserName());
        userOptional.get().setFirstName(request.getFirstName());
        userOptional.get().setLastName(request.getLastName());
        userOptional.get().setAge(request.getAge());
        userRepo.save(userOptional.get());
        return userOptional.get();
    }

    @Override
    public void deleteUser(Long id) {
        //validate xem co user co id
        Optional<User> userOptional = userRepo.findById(id);
        if(userOptional.isEmpty()){
            throw new RuntimeException("Khong co user nay");
        }
        //neu tim thay
        userRepo.delete(userOptional.get());
    }
}
