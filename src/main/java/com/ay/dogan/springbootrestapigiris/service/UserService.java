package com.ay.dogan.springbootrestapigiris.service;

import com.ay.dogan.springbootrestapigiris.entity.User;

import java.util.List;

public interface UserService {

    User createUser (User user); //imzası döner
    List<User> getUsers();
    User getUser(Long id);
    User updateUser(Long id,User user);

    Boolean deleteUser(Long id);

}
