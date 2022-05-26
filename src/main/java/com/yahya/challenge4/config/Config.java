package com.yahya.challenge4.config;

import com.yahya.challenge4.enumeration.ERole;
import com.yahya.challenge4.model.Roles;
import com.yahya.challenge4.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Autowired
    RoleRepository roleRepository;

    private static final Logger LOG = LoggerFactory.getLogger(Config.class);


    @Bean
    public void prerun() {
        for (ERole c : ERole.values()) {
            try {
                roleRepository.findByName(c)
                        .orElseThrow(() -> new RuntimeException("Roles not found"));
            } catch (RuntimeException rte) {
                LOG.info("Role " + c.name() + " is not found, inserting to DB . . .");
                Roles roles = new Roles();
                roles.setName(c);
                roleRepository.save(roles);
            }
        }
    }
}
