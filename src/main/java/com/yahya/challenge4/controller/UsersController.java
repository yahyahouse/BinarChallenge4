package com.yahya.challenge4.controller;

import com.yahya.challenge4.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/api")
public class UsersController {
    @Autowired
    private UsersService userService;

    @PostMapping("/add-user")
    public String addUser(Integer userId,String username, String password,String email){
        userService.addUser(userId,username, password,email);
        return "user berhasil di tambahkan";
    }

    @PutMapping("/update-user")
    public String updateUser(Integer userId,String username,String password, String email){
        userService.updateUsers(userId,username,password,email);
        return "update berhasil";
    }

    @DeleteMapping("/delete-user")
    public String deleteUser(String username){
        userService.deleteFilm(username);
        return "delete berhasil";
    }
}
