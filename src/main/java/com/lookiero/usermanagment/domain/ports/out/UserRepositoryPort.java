package com.lookiero.usermanagement.domain.ports.out;

import com.lookiero.usermanagement.domain.model.User;

import java.util.List;
import java.util.Optional;


public interface UserRepositoryPort {
    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);

    List<User> findAll();

    User save(User user);

    void delete(User user);
    // Other methods as needed
}
