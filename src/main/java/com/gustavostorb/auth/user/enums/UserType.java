package com.gustavostorb.auth.user.enums;

import java.util.Arrays;

public enum UserType {

    ADMIN,
    USER;

    public static UserType getType(String name) {
        return Arrays.stream(UserType.values())
                .filter((userType -> userType.name().equals(name)))
                .findFirst()
                .orElse(null);
    }
}
