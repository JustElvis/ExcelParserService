package com.example.excelparserservice.controller;

import com.example.excelparserservice.config.jwt.JwtProvider;
import com.example.excelparserservice.dto.AuthRequestDto;
import com.example.excelparserservice.dto.AuthResponseDto;
import com.example.excelparserservice.dto.RegistrationRequestDto;
import com.example.excelparserservice.dto.mapper.RegistrationMapper;
import com.example.excelparserservice.entity.UserEntity;
import com.example.excelparserservice.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private RegistrationMapper registrationMapper;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    @ApiOperation(value = "Registration user with ROLE_USER")
    public String registerUser(@RequestBody RegistrationRequestDto registrationRequestDto) {
        userService.saveUser(registrationMapper.mapToEntity(registrationRequestDto));
        return "Done";
    }

    @PostMapping("/auth")
    @ApiOperation(value = "Authentication")
    public AuthResponseDto auth(@RequestBody AuthRequestDto authRequestDto) {
        UserEntity userEntity = userService.findByLoginAndPassword(authRequestDto.getLogin(),
                authRequestDto.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponseDto(token);
    }
}
