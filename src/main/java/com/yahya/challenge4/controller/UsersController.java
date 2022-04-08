package com.yahya.challenge4.controller;

import com.yahya.challenge4.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UsersController {
    @Autowired
    private UsersService userService;

    public String addUser(String username, String password,String email){
        userService.addUser(username, password,email);
        return "user berhasil di tambahkan";
    }

    public String updateUser(Integer userId,String username,String password, String email){
        userService.updateUsers(userId,username,password,email);
        return "update berhasil";
    }

    public String deleteUser(String username){
        userService.deleteFilm(username);
        return "delete berhasil";
    }
}
