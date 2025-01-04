package com.normdevstorm.commerce_platform.enums;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Getter
@RequiredArgsConstructor
public enum Role {

    USER(
           Set.of(Permission.USER_READ, Permission.USER_CREATE, Permission.USER_UPDATE, Permission.USER_DELETE, Permission.TRANSACTION_READ, Permission.TRANSACTION_CREATE, Permission.TRANSACTION_UPDATE, Permission.PRODUCT_READ)
    ),
    ADMIN(
            Set.of(Permission.USER_READ, Permission.USER_CREATE, Permission.USER_UPDATE, Permission.USER_DELETE, Permission.ADMIN_READ, Permission.ADMIN_CREATE, Permission.ADMIN_UPDATE, Permission.ADMIN_DELETE, Permission.PRODUCT_READ, Permission.PRODUCT_CREATE, Permission.PRODUCT_UPDATE, Permission.PRODUCT_DELETE, Permission.TRANSACTION_READ, Permission.TRANSACTION_CREATE, Permission.TRANSACTION_UPDATE, Permission.TRANSACTION_DELETE)
    );

    @JsonEnumDefaultValue
    public static Role DEFAULT = USER;

    private final Set<Permission> authorities;

    public List<SimpleGrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>(this.authorities.stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
