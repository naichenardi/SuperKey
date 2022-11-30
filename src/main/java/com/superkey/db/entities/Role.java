package com.superkey.db.entities;

import com.superkey.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class Role implements GrantedAuthority {
    private List<RoleName> roles;

    @Override
    public String getAuthority() {
        return RoleName.ROLE_ADMIN.name();
    }

    public List<RoleName> getRoles() {
        return roles;
    }
}
