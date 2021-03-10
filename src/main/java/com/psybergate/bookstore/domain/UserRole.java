package com.psybergate.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserRole {

    ROLE_ADMIN("ROLE_ADMIN"), ROLE_CUSTOMER("ROLE_CUSTOMER");

    @Getter
    private String description;

}
