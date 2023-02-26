package com.attendance.api.mapper;

import com.attendance.api.model.BoardVo;
import com.attendance.api.model.CommentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper{
    List<BoardVo> getBoardList(String id, int page_limit, int page_offset, String keyword) throws Exception;
    List<BoardVo> getMyBoardList(String id) throws Exception;
    int insertPost(BoardVo boardVo);
    int updatePost(BoardVo boardVo);
    int boardCount(String keyword); // 게시글 총 갯수

    //댓글기능 추가
    CommentVo getComment(int num);
    int saveComment(CommentVo commentVo);
    int updateComment(CommentVo commentVo);
}
