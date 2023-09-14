package com.lookiero.usermanagement.domain.model;

import com.lookiero.usermanagement.validation.ValidPassword;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username must not be blank")
    @Size(min = 8, message = "Username must have at least 8 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric")
    @Column(unique = true)
    private String username;

    @NotNull(message = "Age must not be null")
    @Min(value = 18, message = "Age must be 18 or greater")
    private Integer age;

    @Transient
    @ValidPassword
    private String passwordHash; // Store the password hash

    @NotNull(message = "Height must not be null")
    @DecimalMin(value = "1.00", message = "Height must be at least 1.00 m")
    @DecimalMax(value = "2.30", message = "Height must be at most 2.30 m")
    private Double height;

    @NotNull(message = "Weight must not be null")
    @DecimalMin(value = "40", message = "Weight must be at least 40 kg")
    @DecimalMax(value = "150", message = "Weight must be at most 150 kg")
    private Double weight;

    @Past(message = "Birthdate must be in the past")
    private LocalDate birthdate;

    // Constructors, getters, setters, and other methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        if (birthdate != null) {
            LocalDate currentDate = LocalDate.now();
            return Period.between(birthdate, currentDate).getYears();
        }
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPassword(String password) {
        // Hash the password before storing it
        this.passwordHash = new BCryptPasswordEncoder().encode(password);
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public double calculateBMI() {
        if (height != null && weight != null && height > 0 && weight > 0) {
            return weight / (height * height);
        }
        return 0.0;
    }

    // Other methods, validation logic, and domain-specific methods
}
