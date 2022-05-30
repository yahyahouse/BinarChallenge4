package com.yahya.challenge4;

import com.yahya.challenge4.config.JwtUtils;
import com.yahya.challenge4.controller.AuthController;
import com.yahya.challenge4.enumeration.ERole;
import com.yahya.challenge4.model.Roles;
import com.yahya.challenge4.model.SignupRequest;
import com.yahya.challenge4.repository.RoleRepository;
import com.yahya.challenge4.repository.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@ExtendWith(MockitoExtension.class)
class TestAuth {
    private AuthController authController;

    @Mock
    private UsersRepository usersRepository;

    @Spy
    private AuthenticationManager authenticationManager;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtUtils jwtUtils;

    @Mock
    Authentication authentication;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        authController = new AuthController(this.authenticationManager, this.usersRepository,
                this.jwtUtils, this.roleRepository, this.passwordEncoder);
    }

    @Test
    void testSignup() {
        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setUsername("admin");
        signupRequest.setEmail("admin@email.com");
        signupRequest.setPassword("admin");
        signupRequest.setRole(roles);

        Mockito.when(usersRepository.existsByUsername("admin")).thenReturn(Boolean.FALSE);
        Mockito.when(usersRepository.existsByEmail("admin@email.com")).thenReturn(Boolean.FALSE);
        Mockito.when(roleRepository.findByName(ERole.ADMIN))
                .thenReturn(Optional.of(new Roles(1, ERole.ADMIN)));

        Assertions.assertEquals("User registered successfully",
                authController.registerUser(signupRequest).getBody().getMessage());
    }

}
