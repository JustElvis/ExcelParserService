package com.example.excelparserservice.service;

import com.example.excelparserservice.entity.UserEntity;

public interface UserService {
    UserEntity saveUser(UserEntity userEntity);

    UserEntity findByLogin(String login);

    UserEntity findByLoginAndPassword(String login, String password);
}
