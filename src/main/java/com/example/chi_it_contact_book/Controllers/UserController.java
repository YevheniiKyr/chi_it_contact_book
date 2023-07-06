package com.example.chi_it_contact_book.Controllers;

import com.example.chi_it_contact_book.Entities.User;
import com.example.chi_it_contact_book.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
