package com.attendance.api.service;

import com.attendance.api.exception.WrongPasswordException;
import com.attendance.api.mapper.UserMapper;
import com.attendance.api.model.AuthInfo;
import com.attendance.api.model.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public AuthInfo authenticate(String id, String pwd){
        UserVo userVo = userMapper.findById(id);
        if (userVo == null){
            throw new WrongPasswordException();
        }
        if(!userVo.matchPassword(pwd)){
            throw new WrongPasswordException();
        }
        return new AuthInfo(userVo.getId(), userVo.getName());
    }

    public UserVo loginCheck(String id){
        UserVo userVo = userMapper.findById(id);
        return userVo;
    }


}

