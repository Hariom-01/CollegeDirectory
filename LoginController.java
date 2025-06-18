package com.aryajohary.collegedirectory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

   @GetMapping("/")
    public String showHome(){
       return "home";
   }
}
