package com.github.eljaiek.issues;

import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceImplTest {

    private static final int DEFAULT_ID = 1;
    private static final String DEFAULT_EMAIL = "eduardo.eljaiek@gmail.com";
    private static final String DEFAULT_PASSWORD = UUID.randomUUID().toString();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void update() {
        val user = new User(DEFAULT_ID, DEFAULT_EMAIL, DEFAULT_PASSWORD, true);

        userService.update(user);

        assertThat(userRepository.findById(DEFAULT_ID))
                .get()
                .isEqualToComparingFieldByField(user);
    }

    @Test
    public void enable() {
        val entity = userRepository
                .findById(DEFAULT_ID
                ).orElseThrow(NoSuchElementException::new);

        userService.enable(DEFAULT_ID);

        assertThat(userRepository.findById(DEFAULT_ID))
                .get()
                .hasFieldOrPropertyWithValue("enabled", !entity.isEnabled());

    }
}
