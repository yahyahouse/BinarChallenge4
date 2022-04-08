package com.yahya.challenge4.service;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.model.Users;
import com.yahya.challenge4.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImp implements UsersService{
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public void addUser(String username, String password, String email) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        usersRepository.save(user);
    }

    @Override
    public void updateUsers(Integer userId, String newUsername, String newPassword, String newEmail) {
        usersRepository.updateUsers(userId,newUsername,newPassword,newEmail);
    }

    @Override
    public void deleteFilm(String username) {
        usersRepository.deleteUser(username);
    }
}
