package com.attendance.api.service;

import com.attendance.api.mapper.BoardMapper;
import com.attendance.api.model.BoardVo;
import com.attendance.api.model.CommentVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    public List<BoardVo> getBoardList(String id, int page_limit, int page_offset, String keyword) throws Exception{
        return boardMapper.getBoardList(id, page_limit, page_offset, keyword);
    }

    public List<BoardVo> getMyBoardList(String id) throws Exception{
        return boardMapper.getMyBoardList(id);
    }

    public int getBoardCount(String keyword) {
        return boardMapper.boardCount(keyword) ;
    }
    //게시글 총 갯수 카운트

    public int insertPost(BoardVo boardVo){
        return boardMapper.insertPost(boardVo);
    }

    public int updatePost(BoardVo boardVo){
        return boardMapper.updatePost(boardVo);
    }

    //댓글
    public CommentVo getComment(int num){
        return boardMapper.getComment(num);
    }
    public int saveComment(CommentVo commentVo){ return boardMapper.saveComment(commentVo);}
    public int updateComment(CommentVo commentVo){return boardMapper.updateComment(commentVo);}
}
