package com.attendance.api.service;

import com.attendance.api.mapper.UserMapper;
import com.attendance.api.model.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    /**목록 조회 */
    public List<UserVo> getList() throws Exception{
        return userMapper.getList();
    }
    /**유저 생성*/
    public int insertUser(UserVo userVo){
        return userMapper.insertUser(userVo);
    }
    /**로그인 */
    public UserVo findById(String id) throws Exception{
        return userMapper.findById(id);
    }

    /**유저 조회*/
//    public UserVo getUser(@RequestBody UserVo userVo) throws Exception {
//        return userMapper.getUser(userVo);
//    }

}
