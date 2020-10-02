package com.shuang.controller;

import com.shuang.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    //主要我们的接口中，返回值中存在实体类，他就会被扫描到Swagger中。
    @PostMapping("/user")
    public User user(){
        return new User();
    }
    //Operation接口，不是放在类上的,是方法
    @ApiOperation("Hello控制类")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;

    }

    @ApiOperation("post测试类")
    @PostMapping("/postt")
    public User hello3(@ApiParam("用户名") User user){
        return user;

    }
}
