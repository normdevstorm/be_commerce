package com.normdevstorm.commerce_platform.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Role {
    USER,
    ADMIN;

    @JsonEnumDefaultValue
    public static Role DEFAULT = USER;
}
