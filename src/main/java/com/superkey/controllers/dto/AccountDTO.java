package com.superkey.controllers.dto;

import com.superkey.db.entities.Account;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class AccountDTO {
    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String companyName;

    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String email;

    public AccountDTO(String username, String companyName, String password, String email) {
        this.username = username;
        this.companyName = companyName;
        this.password = password;
        this.email = email;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Account toEntity() {
        return new Account(username, companyName, password, email);
    }
}
