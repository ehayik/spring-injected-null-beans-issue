package com.github.eljaiek.issues;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class UserServiceImplTest {

    private static final int DEFAULT_ID = 1;
    private static final String DEFAULT_EMAIL = "eduardo.eljaiek@gmail.com";
    private static final String DEFAULT_PASSWORD = UUID.randomUUID().toString();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    void update() {
        // Given
        val user = new User(DEFAULT_ID, DEFAULT_EMAIL, DEFAULT_PASSWORD, true);

        // When
        userService.update(user);

        // Then
        assertThat(userRepository.findById(DEFAULT_ID)).isPresent();
    }

    @Test
    void enable() {
        // Given
        val entity = userRepository
                .findById(DEFAULT_ID
                ).orElseThrow(NoSuchElementException::new);

        // When
        userService.enable(DEFAULT_ID);

        // Then
        assertThat(userRepository.findById(DEFAULT_ID))
                .get()
                .hasFieldOrPropertyWithValue("enabled", !entity.isEnabled());

    }
}
