package com.github.eljaiek.issues;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public final User update(User user) {
        val entity = loadUserById(user.getId());
        entity.update(user);
        userRepository.save(entity);
        return entity;
    }

    private User loadUserById(@NonNull Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User enable(Integer id) {
        val entity = loadUserById(id);
        entity.setEnabled(!entity.isEnabled());
        return entity;
    }
}
