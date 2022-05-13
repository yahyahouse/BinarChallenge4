package com.yahya.challenge4.repository;

import com.yahya.challenge4.enumeration.ERole;
import com.yahya.challenge4.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {

    Optional<Roles> findByName(ERole name);
}
