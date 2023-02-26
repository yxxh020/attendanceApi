package com.attendance.api.controller;

import com.attendance.api.model.BoardVo;
import com.attendance.api.model.CommentVo;
import com.attendance.api.model.SearchVo;
import com.attendance.api.model.UserVo;
import com.attendance.api.service.BoardService;
import com.attendance.api.service.UserService;
import com.sun.mail.iap.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
@Api(tags="출석체크 게시판")
public class
BoardController {

    private final BoardService boardService;
    private final UserService userService;
    BoardVo boardVo;

    @GetMapping("/{id}")
    public List<BoardVo> getMyBoardList(@PathVariable("id") String id) throws Exception{
        return boardService.getMyBoardList(id);
    };

    @GetMapping("/")
    public SearchVo getBoardList(
            @RequestParam(value="id",required = false) String id,
            @RequestParam("page_limit") int page_limit,
            @RequestParam("page_offset") int page_offset,
            @RequestParam(value="keyword",required = false) String keyword
    ) throws Exception{
        List<BoardVo> items = boardService.getBoardList(id, page_limit, page_offset, keyword);
        int count = boardService.getBoardCount(keyword);

        return SearchVo.builder()
                .keyword(keyword)
                .offset(page_offset)
                .items(items)
                .total(count)
                .build();
    }

    @ApiOperation(value="글추가", notes="글추가")
    @PostMapping(value="/post")
    public int insertPost(@RequestBody BoardVo boardVo ) throws Exception {

        String id = boardVo.getId();
        UserVo userVo = userService.findById(id);
        char admin_yn = userVo.getAdmin_yn();
        if(admin_yn != 'Y'){
            String name = userVo.getName();
            String dept = userVo.getDept();
            boardVo.setName(name);
            boardVo.setDept(dept);
            boardService.insertPost(boardVo);
        }
        return Response.OK;
    }


    @ApiOperation(value="글수정", notes="글수정")
    @PutMapping(value="/update")
    public int updatePost(@RequestBody BoardVo boardVo){

        return boardService.updatePost(boardVo);
    }

    @ApiOperation("댓글보기")
    @GetMapping(value="/getComment")
    public CommentVo getComment(@RequestParam("num") int num) throws Exception{
        return boardService.getComment(num);
    }

    @ApiOperation("댓글추가")
    @PostMapping(value="/saveComment")
    public int saveComment(@RequestBody CommentVo commentVo) throws Exception{
        return Response.OK;
    }

    @ApiOperation("댓글수정")
    @PutMapping(value="/updateComment")
    public int updateComment(@RequestBody CommentVo commentVo) throws Exception{
        return Response.OK;
    }

}

