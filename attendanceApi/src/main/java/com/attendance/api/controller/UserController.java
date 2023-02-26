package com.attendance.api.controller;

import com.attendance.api.exception.WrongPasswordException;
import com.attendance.api.model.AuthInfo;
import com.attendance.api.model.Login;
import com.attendance.api.model.UserVo;
import com.attendance.api.service.AuthService;
import com.attendance.api.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/user")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    @GetMapping
    public List<UserVo> getList() throws Exception {
        return userService.getList();
    }

    @GetMapping(value="get/{id}")
    public UserVo findById(@PathVariable("id") String id) throws Exception{
        return userService.findById(id);
    }

    @ApiOperation(value="회원가입", notes="회원가입")
    @PostMapping(value="/signup")
    public int insertUser(@RequestBody UserVo userVo){
        return userService.insertUser(userVo);
    }



    @PostMapping("/login")
    public ResponseEntity Login(
            @RequestBody Login Login,
            HttpSession httpSession){
        try{

            AuthInfo authInfo = authService.authenticate(Login.getId(),Login.getPwd());

            httpSession.setAttribute("authInfo",authInfo);
            httpSession.setAttribute("userId",Login.getId());

            return ResponseEntity.ok("{ \"message\":\"login_success\"}");

        }catch (WrongPasswordException e){
            return new ResponseEntity("{ \"message\": \"login_failed\"}",HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity Logout(HttpSession httpSession){
        httpSession.invalidate();
        return new ResponseEntity("{ \"message:\" : \"Logout_Success\" }", HttpStatus.OK);
    }


}

