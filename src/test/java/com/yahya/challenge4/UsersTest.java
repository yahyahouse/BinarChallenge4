package com.yahya.challenge4;


import com.yahya.challenge4.controller.UsersController;
import com.yahya.challenge4.service.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersTest {

    @Autowired
    private UsersController usersController;

    @Test
    @DisplayName("Test menambahkan user")
    public void addUser(){
        String tambah = usersController.addUser("wijaya","4321","wijaya@email.com");
        Assertions.assertEquals("user berhasil di tambahkan",tambah);
    }

    @Test
    @DisplayName("Test UPDATE user")
    public void updateUser(){usersController.updateUser(6,"jaya","1234567","jaya@email.com");}

    @Test
    @DisplayName("Test DELETE user")
    public void deleteUser(){
        usersController.deleteUser("wijaya");
    }
}
