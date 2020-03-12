package com.scoder.hs.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum Role{
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String value;
}