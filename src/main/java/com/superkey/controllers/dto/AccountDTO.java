package com.superkey.controllers.dto;

import com.superkey.db.entities.Account;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class AccountDTO {
    @Null
    private String username;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
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
