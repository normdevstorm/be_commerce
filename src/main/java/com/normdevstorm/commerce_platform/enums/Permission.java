package com.normdevstorm.commerce_platform.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum Permission {

    USER_READ("user:read"),
    USER_CREATE("user:create"),
    USER_DELETE("user:delete"),
    USER_UPDATE("user:update"),

    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    ADMIN_UPDATE("admin:update"),

    PRODUCT_READ("product:read"),
    PRODUCT_CREATE("product:create"),
    PRODUCT_DELETE("product:delete"),
    PRODUCT_UPDATE("product:update"),

    TRANSACTION_READ("transaction:read"),
    TRANSACTION_CREATE("transaction:create"),
    TRANSACTION_DELETE("transaction:delete"),
    TRANSACTION_UPDATE("transaction:update");

    private final String permission;



}
