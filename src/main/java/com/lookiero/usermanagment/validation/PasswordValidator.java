package com.lookiero.usermanagement.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        // Initialization, if needed
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        // Implement your password validation logic here
        // For example, check for non-blank and other rules
        if (password == null || password.isBlank()) {
            return false;
        }

        // Add more validation rules as needed

        return true; // Password is valid
    }
}
