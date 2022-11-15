package com.superkey.controllers.dto;

import com.superkey.db.entities.Account;

public class AccountDTO {
    private String username;
    private String password;
    private String email;

    public AccountDTO(String companyName, String email, String password) {
        this.username = companyName;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Account toEntity() {
        return new Account(username, email, password);
    }
}
