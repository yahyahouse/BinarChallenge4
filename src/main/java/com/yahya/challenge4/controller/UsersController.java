package com.yahya.challenge4.controller;

import com.yahya.challenge4.model.Schedules;
import com.yahya.challenge4.model.Users;
import com.yahya.challenge4.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/api")
public class UsersController {
    private static final Logger LOG = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private UsersService userService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil Menambahkan User!",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Schedules.class)) })})
    @Operation(summary = "menambahkan user ke database pada tabel users")
    @PostMapping("/add-user")
    public String addUser(@Schema(example = "{" +
            "\"userId\":\"1\"," +
            "\"username\":\"yahya\"," +
            "\"password\":\"1234\"," +
            "\"email\":\"yahya@email.com\"" +
            "}")Integer userId,String username, String password,String email){
        userService.addUser(userId,username, password,email);
        return "user berhasil di tambahkan";
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil Mengubah Data Pada tabel User",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Schedules.class)) })})
    @Operation(summary="Mengubah data yang sudah ada pada tabel user")
    @PutMapping("/update-user")
    public String updateUser(@Schema(example = "{" +
            "\"userId\":\"1\"," +
            "\"username\":\"wijaya\"," +
            "\"password\":\"4321\"," +
            "\"email\":\"wijaya@email.com\"" +
            "}")Integer userId,String username,String password, String email){
        userService.updateUsers(userId,username,password,email);
        return "update berhasil";
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil Menghapus User",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Schedules.class)) })})
    @Operation(summary="menghapus user sesuai dengan username yang dimasukan")
    @DeleteMapping("/delete-user")
    public String deleteUser(String username){
        userService.deleteFilm(username);
        return "delete berhasil";
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Berhasil Menampilkan User",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Schedules.class)) })})
    @Operation(summary="menampilkan username dan email dari tabel user sesuai dengan username ")
    @GetMapping(value="/get-user/{username}")
    public Users getUsersByUsername(@PathVariable("username") String username) {
        Users user = userService.getUsersByUsername(username);
        LOG.info("film added: {}", getUsersByUsername(username));
        return user;
    }
}
