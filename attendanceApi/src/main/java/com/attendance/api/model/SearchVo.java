package com.attendance.api.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SearchVo {
    private String keyword;
    int total;
    int offset;
    List<BoardVo> items;
    //items은 BoardVo들의 값이 들어있는 리스트
}
