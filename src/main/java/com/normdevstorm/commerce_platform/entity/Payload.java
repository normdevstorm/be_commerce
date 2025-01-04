package com.normdevstorm.commerce_platform.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Payload implements Serializable {
    private UUID id;
    private String role;
    private Integer version;
    private String username;

}
