package com.yahya.challenge4.service;

import com.yahya.challenge4.model.Users;
import com.yahya.challenge4.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImp implements UsersService {
    private static final Logger LOG = LoggerFactory.getLogger(UsersServiceImp.class);
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    public void UserServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public void addUser(Integer userId, String username, String password, String email) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        usersRepository.save(user);
    }

    @Override
    public void updateUsers(Integer userId, String newUsername, String newPassword, String newEmail) {
        usersRepository.updateUsers(userId, newUsername, newPassword, newEmail);
    }

    @Override
    public void deleteFilm(String username) {
        usersRepository.deleteUser(username);
    }

    @Override
    public Users getUsersByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public void getUsername(String username) {
        usersRepository.getUsersByUsername(username);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
