package com.attendance.api.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Data
@Alias("Board") //@Alias("별칭") 어노테이션이 지정된 클래스는 매퍼파일에서 해당 클래스를 매핑해줌.
public class BoardVo {

    private int num;
    private String name;
    private String dept;
    private String reg_time;
    private String id;


    public BoardVo(String name, String dept, String reg_time){
        this.name=name;
        this.dept=dept;
        this.reg_time=reg_time;
    };
}
