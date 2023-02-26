package com.attendance.api.service;

import com.attendance.api.model.UserVo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    List<UserVo> getList() throws Exception;
    int insertUser(UserVo userVo);
    UserVo findById(String id) throws Exception;
//    UserVo getUser(@RequestBody UserVo userVo) throws Exception;

}
