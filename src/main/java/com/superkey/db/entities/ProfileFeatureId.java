package com.superkey.db.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProfileFeatureId implements Serializable {
    private static final long serialVersionUID = -3691436548031135287L;
    @Column(name = "fk_featureId", nullable = false)
    private Long fkFeatureid;

    @Column(name = "fk_profileId", nullable = false)
    private Long fkProfileid;

    public Long getFkFeatureid() {
        return fkFeatureid;
    }

    public void setFkFeatureid(Long fkFeatureid) {
        this.fkFeatureid = fkFeatureid;
    }

    public Long getFkProfileid() {
        return fkProfileid;
    }

    public void setFkProfileid(Long fkProfileid) {
        this.fkProfileid = fkProfileid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProfileFeatureId entity = (ProfileFeatureId) o;
        return Objects.equals(this.fkProfileid, entity.fkProfileid) &&
                Objects.equals(this.fkFeatureid, entity.fkFeatureid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fkProfileid, fkFeatureid);
    }

}