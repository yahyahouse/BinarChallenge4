package com.yahya.challenge4.controller;

import com.yahya.challenge4.model.Users;
import com.yahya.challenge4.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/api")
public class UsersController {
    @Autowired
    private UsersService userService;

    @Operation(summary = "menambahkan user ke database pada tabel users")
    @PostMapping("/add-user")
    public String addUser(Integer userId,String username, String password,String email){
        userService.addUser(userId,username, password,email);
        return "user berhasil di tambahkan";
    }

    @Operation(summary="Mengubah data yang sudah ada pada tabel user")
    @PutMapping("/update-user")
    public String updateUser(Integer userId,String username,String password, String email){
        userService.updateUsers(userId,username,password,email);
        return "update berhasil";
    }

    @Operation(summary="menghapus user sesuai dengan username yang dimasukan")
    @DeleteMapping("/delete-user")
    public String deleteUser(String username){
        userService.deleteFilm(username);
        return "delete berhasil";
    }

    @Operation(summary="menampilkan username dan email dari tabel user sesuai dengan username ")
    @GetMapping(value="/get-user/{username}")
    public Users getUsersByUsername(@PathVariable("username") String username) {
        Users user = userService.getUsersByUsername(username);
        System.out.println("Username : " + user.getUsername()
                + "\nEmail : " + user.getEmail());
        return user;
    }
}
