package com.system.afnai_managment.service.impl;

import com.system.afnai_managment.entity.User;
import com.system.afnai_managment.pojo.UserPojo;
import com.system.afnai_managment.repo.UserRepo;
import com.system.afnai_managment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService {
    private final UserRepo userRepo;


    @Override
    public String saveUser(UserPojo userPojo) {
        User user = new User();
        user.setUserName(userPojo.getUserName());
        user.setEmail(userPojo.getEmail());
        user.setMobileNo(userPojo.getMobileNo());
        user.setPassword(userPojo.getPassword());
        userRepo.save(user);
        return "created";

    }

    @Override
    public List<User> fetchAll() {
        return userRepo.findAll();
    }

    @Override
    public User fetchById(Integer id) {
        return userRepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }

    @Override
    public void delteById(Integer id) {
        userRepo.deleteById(id);
    }


}
