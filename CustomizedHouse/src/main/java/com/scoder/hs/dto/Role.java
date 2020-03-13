package com.scoder.hs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum Role{
    ADMIN("ROLE_ADMIN"),
    GENUSER("ROLE_GENUSER"),
	REAUSER("ROLE_REAUSER");

    private String value;
}