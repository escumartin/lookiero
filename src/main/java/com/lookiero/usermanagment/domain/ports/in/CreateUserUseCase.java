package com.lookiero.usermanagement.domain.ports.in;

import com.lookiero.usermanagement.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
