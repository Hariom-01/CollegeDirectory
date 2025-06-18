package com.aryajohary.collegedirectory.controllers;

import com.aryajohary.collegedirectory.schemas.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/syntax")
    public User sendSytanx(){
        return new User();
    }

}
