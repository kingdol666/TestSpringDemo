package com.kingdol.testspringdemo1.controller;

import com.kingdol.testspringdemo1.api.Response;
import com.kingdol.testspringdemo1.entity.UserInfo;
import com.kingdol.testspringdemo1.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//http://localhost:8081/userinfo/
@RestController
@RequestMapping("/userinfo/")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public Response<?> getUserInfo(@RequestParam Long userId){
        return Response.ok(userInfoService.findUserInfoById(userId));
    }

    @PostMapping
    public Response<?> saveUserInfo(@RequestBody UserInfo userInfo){
        return Response.ok(userInfoService.saveUserInfo(userInfo));
    }

    @DeleteMapping
    public Response<?> deleteUserInfo(@RequestParam Long userId){
        return Response.ok(userInfoService.deleteUserInfo(userId));
    }

    @PutMapping
    public Response<?> updateUserInfo(@RequestBody UserInfo userInfo){
        return Response.ok(userInfoService.updateUserInfo(userInfo));
    }
}

