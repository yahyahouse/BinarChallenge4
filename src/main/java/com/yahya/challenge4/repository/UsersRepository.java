package com.yahya.challenge4.repository;

import com.yahya.challenge4.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query("select u from users u where u.username = :username and u.email = :email")
    public Users findByUsernameAndEmail(@Param("username") String userName, @Param("email") String email);

    public Users findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Query(value = "select * from users u " +
            "join user_type ut on ut.type_id = u.type_id " +
            "where ut.type_name = :typeName", nativeQuery = true)
    public List<Users> findByTypeName(@Param("typeName") String typeName);

    @Transactional
    @Modifying
    @Query("UPDATE users u SET u.username=?2, u.password=?3, u.email=?4 WHERE u.userId=?1")
    void updateUsers(Integer userId, String newUsername, String newPassword, String newEmail);

    @Transactional
    @Modifying
    @Query("DELETE FROM users u WHERE u.username=?1 ")
    void deleteUser(String username);

    @Query("SELECT u FROM users u WHERE u.username=?1")
    void getUsersByUsername(String username);
}
