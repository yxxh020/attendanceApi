package com.attendance.api.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("Comment")
public class CommentVo {
    private int num;
    private String comment;
    private int ref_num;
    private String uid;
}
