package com.example.demo.controllers;

import com.example.demo.authentication.UserAuthenticationService;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;


import java.util.List;
import java.util.Optional;

//@FieldDefaults(level = PRIVATE)
//@AllArgsConstructor(access = PACKAGE)
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @NonNull
    @Autowired
    UserAuthenticationService authentication;

//    @GetMapping("/")
//    public String allUsers(Model model) {
//        List<User> users = userService.findAll();
//        model.addAttribute("users", users);
//
//        return "listUsers";
//    }

    @GetMapping("/")
    public String allUsers() {

        return "<h1>Hello user<h1>";
    }


//    @PostMapping("/login")
//    String login(
//            @RequestParam("username") final String username,
//            @RequestParam("password") final String password) {
//
//        return Optional.ofNullable(authentication.login(username, password))
//                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
//    }

}
