package com.spring.cake.service.impl;

import com.bilibili.yl.util.MD5Utils;
import com.spring.cake.model.UsersEntity;
import com.spring.cake.repository.UserRepository;
import com.spring.cake.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Override
    public UsersEntity register(UsersEntity user) {
        user.setUsername("用户_" + UUID.randomUUID().toString().split("-")[0].toUpperCase());
        user.setPassword(MD5Utils.MD5Encode(user.getPassword(), "utf-8"));
        return userRepository.save(user);
    }

    @Override
    public UsersEntity checkMailIsExists(String mail) {
        return userRepository.findUsersEntityByMail(mail);
    }

    @Override
    public UsersEntity login(String mail, String password) {
        return userRepository.findUsersEntityByMailAndPassword(mail, password);

    }
}
