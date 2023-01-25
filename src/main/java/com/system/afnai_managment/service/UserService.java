package com.system.afnai_managment.service;

import com.system.afnai_managment.entity.User;
import com.system.afnai_managment.pojo.UserPojo;

import java.util.List;

public interface UserService {
    String saveUser(UserPojo userpojo);
    List<User> fetchAll();
    User fetchById(Integer id);
    void delteById(Integer id);
    void sendEmail();


    User findByEmail(String email);
}
