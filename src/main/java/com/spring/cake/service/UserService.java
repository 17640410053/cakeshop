package com.spring.cake.service;

import com.spring.cake.model.UsersEntity;

public interface UserService {
    UsersEntity register(UsersEntity user);

    UsersEntity checkMailIsExists(String mail);

    UsersEntity login(String mail, String password);
}
