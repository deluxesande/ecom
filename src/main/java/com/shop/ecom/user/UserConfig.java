package com.shop.ecom.user;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.shop.ecom.user.model.Role;
import com.shop.ecom.user.model.User;
import com.shop.ecom.user.repository.UserRepository;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner UserCommandLineRunner(UserRepository userRepository) {
        return arg -> {
            User user1 = new User("john doe", "john@gmail.com", "1234", Role.STUDENT);
            User user2 = new User("jane doe", "jane@gmail.com", "1234", Role.STUDENT);

            userRepository.saveAll(List.of(user1, user2));
        };
    }
}
