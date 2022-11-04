package com.superkey.db.entities;

import javax.persistence.*;

@Entity
@Table(name = "profile_feature")
public class ProfileFeature {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private ProfileFeatureId id;

    public ProfileFeatureId getId() {
        return id;
    }

    public void setId(ProfileFeatureId id) {
        this.id = id;
    }

}