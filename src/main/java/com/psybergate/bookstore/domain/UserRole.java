package com.psybergate.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum UserRole {

    ADMIN("ROLE_ADMIN"), CUSTOMER("ROLE_CUSTOMER");

    @Getter
    private String description;

}
