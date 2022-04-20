package com.yahya.challenge4.service;

import com.yahya.challenge4.model.Users;

public interface UsersService {
    public void addUser(Integer userId,String username, String password,String email);
    public void updateUsers(Integer userId,String newUsername,String newPassword, String newEmail);
    public void deleteFilm(String username);
    public Users getUsersByUsername(String username);
}
