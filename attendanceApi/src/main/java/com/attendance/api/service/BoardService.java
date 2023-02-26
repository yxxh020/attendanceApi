package com.attendance.api.service;

import com.attendance.api.model.BoardVo;
import com.attendance.api.model.CommentVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService{

     List<BoardVo> getBoardList(String id, int page_limit, int page_offset, String keyword) throws Exception;
     List<BoardVo> getMyBoardList(String id) throws Exception;
     int getBoardCount(String keyword);
     int insertPost(BoardVo boardVo);
     int updatePost(BoardVo boardVo);

     CommentVo getComment(int num);
     int saveComment(CommentVo commentVo);
     int updateComment(CommentVo commentVo);
}
