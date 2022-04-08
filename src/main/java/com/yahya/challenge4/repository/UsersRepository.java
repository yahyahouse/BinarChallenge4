package com.yahya.challenge4.repository;

import com.yahya.challenge4.model.Films;
import com.yahya.challenge4.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE users u SET u.username=?2, u.password=?3, u.email=?4 WHERE u.userId=?1")
    void updateUsers(Integer userId,String username,String password, String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM users u WHERE u.username=?1 ")
    void deleteUser(String username);
}
