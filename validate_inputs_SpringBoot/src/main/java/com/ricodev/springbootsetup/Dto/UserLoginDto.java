package com.ricodev.springbootsetup.Dto;

import jakarta.validation.constraints.*;

public class UserLoginDto {
//    add validations to our dto

    @NotBlank (message = "Name field is required")
    private String name;
    @Email(message = "Invalid email address, please provide a valid email")
    private String  email;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$"
            ,message = "Weak password,password should be  at least 8 characters and " +
            "contain at least a digit,an uppercase special character ")
    private String  password;

//    Constructors
    public UserLoginDto() {
    }
//    Getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
