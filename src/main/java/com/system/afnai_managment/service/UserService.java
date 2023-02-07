package com.system.afnai_managment.service;

import com.system.afnai_managment.entity.User;
import com.system.afnai_managment.pojo.UserPojo;

import java.io.IOException;
import java.util.List;

public interface UserService {
    UserPojo saveUser(UserPojo userpojo) throws IOException;
    List<User> fetchAll();
    User fetchById(Integer U_id);
    void delteById(Integer U_id);
    void sendEmail();


    UserPojo findByEmail(String email);
}
