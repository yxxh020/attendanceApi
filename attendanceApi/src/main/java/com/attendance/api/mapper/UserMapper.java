package com.attendance.api.mapper;

import com.attendance.api.model.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    List<UserVo> getList() throws Exception;
//    UserVo getUser(UserVo userVo) throws Exception;
    int insertUser(UserVo userVo);
    UserVo findById(String id);

}
