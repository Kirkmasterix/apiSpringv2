package com.example.demo.business;

import com.example.demo.config.security.JWTAuthtenticationConfig;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/api/v1/auth")
public class LoginController {

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @PostMapping("login")
    public User login(
            @RequestParam("user") String username,
            @RequestParam("encryptedPass") String encryptedPass) {



        String token = jwtAuthtenticationConfig.getJWTToken(username);
        return new User(username, encryptedPass,token);

    }
}