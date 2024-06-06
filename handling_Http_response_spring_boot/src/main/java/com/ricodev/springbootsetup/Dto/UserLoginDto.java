package com.ricodev.springbootsetup.Dto;

public class UserLoginDto {
    private String name;
    private String  email;
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
