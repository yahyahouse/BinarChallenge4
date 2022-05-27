package com.yahya.challenge4.UsersTest;


import com.yahya.challenge4.controller.UsersController;
import com.yahya.challenge4.repository.UsersRepository;
import com.yahya.challenge4.service.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsersTest {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersController usersController;

    @Autowired
    private UsersService usersService;


    @Test
    @DisplayName("Test menampilkan data user")
    void findUserByUsername(){
        Assertions.assertDoesNotThrow(() -> usersController.getUsersByUsername("yahya"));
    }
    @Test
    @DisplayName("Test menambahkan user")
    void addUser(){
        String tambah = usersController.addUser(1,"wijaya","4321","wijaya@email.com");
        Assertions.assertEquals("user berhasil di tambahkan",tambah);
    }

    @Test
    @DisplayName("Test UPDATE user")
    void updateUser(){
        String updateUser = usersController.updateUser(1,"yahya","1234567","yahya@email.com");
        Assertions.assertEquals("update berhasil",updateUser);
    }
    @Test
    @DisplayName("Test menambahkan user")
    void addUserToDelete(){
        String tambah = usersController.addUser(3,"wijaya","4321","wijaya@email.com");
        Assertions.assertEquals("user berhasil di tambahkan",tambah);
    }


    @Test
    @DisplayName("Test DELETE user")
    void deleteUser(){
        Assertions.assertEquals("delete berhasil",usersController.deleteUser("wijaya"));
    }
}
