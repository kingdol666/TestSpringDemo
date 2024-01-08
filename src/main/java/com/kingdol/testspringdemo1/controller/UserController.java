package com.kingdol.testspringdemo1.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.kingdol.testspringdemo1.api.Response;
import com.kingdol.testspringdemo1.entity.UserEntity;
import com.kingdol.testspringdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserService userService;
    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=kingdol&password=123456
    @GetMapping("doLogin")
    public Response<?> doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if(userService.verifyUser(username, password)!=null){
            var user = userService.getUserByName(username);
            StpUtil.login(user.getId());
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            System.out.println(tokenInfo.getTokenValue());
            return Response.ok(tokenInfo.getTokenValue());
        }else{
            return Response.error("登录失败", 500);
        }
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @GetMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    @GetMapping("verify")
    public Response<?> TokenVerify(@RequestHeader String token){
        Object loginIdByToken = StpUtil.getLoginIdByToken(token);
        Long loginId = Long.parseLong(loginIdByToken.toString());
        // 返回用户ID
        UserEntity userById = userService.getUserById(loginId);
        if(userById==null){
            return Response.error("用户不存在", 500);
        }
        else
            return Response.ok(userById);
    }

    @GetMapping("getAllUsers")
    public Response<?> getAllUsers(){
        return Response.ok(userService.getAllUserss());
    }
}