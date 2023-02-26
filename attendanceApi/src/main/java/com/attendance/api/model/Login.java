package com.attendance.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Login {
    String id;
    String pwd;
    public Login(String id, String pwd){
        this.id = id;
        this.pwd =pwd;
    }

    public Login(){

    }
}

