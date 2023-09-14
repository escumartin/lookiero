package com.lookiero.usermanagement.infrastructure.persistence;

import com.lookiero.usermanagement.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepositoryJPA extends JpaRepository<User, Long> {

    List<User> findAllByOrderByBirthdateAsc();

    Optional<User> findByUsername(String username);

    // Additional custom query methods can be added here
}
