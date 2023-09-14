package com.lookiero.usermanagement.domain.ports.in;

import com.lookiero.usermanagement.domain.model.User;

public interface UpdateUserUseCase {
    User updateUser(Long userId, User updatedUserData);
}
