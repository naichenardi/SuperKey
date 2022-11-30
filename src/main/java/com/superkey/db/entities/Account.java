package com.superkey.db.entities;

import com.superkey.controllers.dto.AccountDTO;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


@Entity
@Table(name = "accounts")
@SQLDelete(sql = "UPDATE accounts SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "company_name", length = 100)
    private String companyName;

    @Column(name = "email", length = 200)
    private String email;

    @Column(name = "password", length = 10)
    private String password;

    @Column(name = "username", length = 10)
    private String username;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

    public Account() {

    }

    public Account(String companyName, String email, String password) {
        this.companyName = companyName;
        this.email = email;
        this.password = password;
    }

    public Account(String username, String companyName, String password, String email) {
        this.companyName = companyName;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new Role());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isDeleted();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AccountDTO toDTO() {
        return new AccountDTO(this.username, this.companyName, this.password, this.email);
    }
}