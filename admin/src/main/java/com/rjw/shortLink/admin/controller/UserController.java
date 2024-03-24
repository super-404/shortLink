package com.rjw.shortLink.admin.controller;

import com.rjw.shortLink.admin.common.convention.enums.UserErrorCodeEnum;
import com.rjw.shortLink.admin.common.convention.result.Result;
import com.rjw.shortLink.admin.common.convention.result.Results;
import com.rjw.shortLink.admin.dto.resp.UserRespDTO;
import com.rjw.shortLink.admin.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: shortLink
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-23 15:44
 **/
@RequestMapping("/admin")
@RestController
@RequiredArgsConstructor
public class UserController {
    @Resource
    private UserServiceImpl userService;
    @GetMapping("/v1/user/{username}")
    public Result test(@PathVariable("username") String userName){
        //System.out.println ("开始处理/v1/user");
        UserRespDTO  upd = userService.getUserByName (userName);
        if(upd != null){
            return Results.success (upd);
        }else{
            return Results.failure (UserErrorCodeEnum.USER_NULL.message ());
        }
    }
    @GetMapping("/test")
    public String test1(String userName){
        return "asdjajsd";
    }

}
