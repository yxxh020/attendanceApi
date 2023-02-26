package com.attendance.api.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@Alias("User")
public class UserVo implements Serializable {
    private Long idx;
    private String name;
    private String id;
    private String pwd;
    private String dept;
    private char admin_yn;
    public boolean matchPassword(String pwd){
        return this.pwd.equals(pwd);
    }

}
