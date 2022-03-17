package com.example.prommer.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Authority implements GrantedAuthority {
    STUDENT,
    TEACHER,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
