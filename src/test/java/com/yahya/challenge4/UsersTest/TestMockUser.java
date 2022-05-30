package com.yahya.challenge4.UsersTest;

import com.yahya.challenge4.controller.UsersController;
import com.yahya.challenge4.model.Users;
import com.yahya.challenge4.repository.UsersRepository;
import com.yahya.challenge4.service.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TestMockUser {

    @Mock
    private UsersController usersController;

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private UsersService usersService;


    @Test
    @DisplayName("Test GET user")
    void TestFindUserByUsername() {
        Users expected = new Users();
        expected.setUsername("admin");
        Assertions.assertDoesNotThrow(() -> usersController.getUsersByUsername(expected.getUsername()));

    }
    @Test
    @DisplayName("Test UPDATE User")
    void TestUpdateUser(){
        Users updateUsers = new Users();
        updateUsers.setUserId(1);
        updateUsers.setEmail("update@email.com");
        updateUsers.setPassword("update");
        updateUsers.setUsername("update");
        Assertions.assertDoesNotThrow(() -> usersService.updateUsers(updateUsers.getUserId(), updateUsers.getUsername()
                , updateUsers.getPassword(), updateUsers.getEmail()));
    }

}
