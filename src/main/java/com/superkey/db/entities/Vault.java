package com.superkey.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "vault")
public class Vault {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "code", length = 200)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_account_id")
    private Account fkAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Account getFkAccount() {
        return fkAccount;
    }

    public void setFkAccount(Account fkAccount) {
        this.fkAccount = fkAccount;
    }

}