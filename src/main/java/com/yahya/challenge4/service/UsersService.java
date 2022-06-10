package com.yahya.challenge4.service;

import com.yahya.challenge4.model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    public void addUser(Integer userId, String username, String password, String email);

    public void updateUsers(Integer userId, String newUsername, String newPassword, String newEmail);

    public void deleteFilm(String username);

    public Users getUsersByUsername(String username);

    public void getUsername(String username);

    public List<Users> getAllUsers();
    public Optional<Users> getUser(Integer userId);
}
