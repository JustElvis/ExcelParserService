package com.example.excelparserservice.dto.mapper;

import com.example.excelparserservice.dto.RegistrationRequestDto;
import com.example.excelparserservice.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class RegistrationMapper {

    public UserEntity mapToEntity(RegistrationRequestDto registrationRequestDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(registrationRequestDto.getLogin());
        userEntity.setPassword(registrationRequestDto.getPassword());
        return userEntity;
    }
}
