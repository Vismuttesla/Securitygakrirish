package com.example.demo.config;

import com.example.demo.entity.User1;
import com.example.demo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class JpaAuditingConfig
{
       private final UserRepository userRepository;

    public JpaAuditingConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
     public AuditorAware<User1> userAuditorAware()
        {
            return new AuditorAware<User1>() {
                @Override
                public Optional<User1> getCurrentAuditor() {
                    return Optional.empty();
                }
            };
        }
        }
