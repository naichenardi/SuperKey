package com.superkey.db.entities;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
@SQLDelete(sql = "UPDATE profiles SET deleted = true WHERE id = ?")
@Where(clause = "deleted=false")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "code", length = 10)
    private String code;

    @Column(name = "deleted")
    private boolean deleted = Boolean.FALSE;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isDeleted() {
        return deleted;
    }
}