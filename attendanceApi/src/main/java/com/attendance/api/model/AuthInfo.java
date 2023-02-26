package com.attendance.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthInfo {
    private String id;
    private String name;

    public AuthInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

}

