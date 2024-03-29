package com.rjw.shortLink.admin.controller;

import com.rjw.shortLink.admin.common.convention.enums.UserErrorCodeEnum;
import com.rjw.shortLink.admin.common.convention.errorcode.BaseErrorCode;
import com.rjw.shortLink.admin.common.convention.result.Result;
import com.rjw.shortLink.admin.common.convention.result.Results;
import com.rjw.shortLink.admin.dto.req.UserRegisterReqDTO;
import com.rjw.shortLink.admin.dto.resp.UserRespDTO;
import com.rjw.shortLink.admin.service.impl.UserServiceImpl;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Result getUserByName(@PathVariable("username") String userName) {
        //System.out.println ("开始处理/v1/user");
        UserRespDTO upd = userService.getUserByName (userName);
        if (upd != null) {
            return Results.success (upd);
        } else {
            return Results.failure (UserErrorCodeEnum.USER_NULL.message ());
        }
    }

    @PostMapping("/v1/user")
    public Result register(@RequestBody UserRegisterReqDTO userRegisterReqDTO) {

        if (userRegisterReqDTO == null) {
            return Results.failure (BaseErrorCode.SERVICE_ERROR.code (),"传输对象对空");
        }
        if(userService.hasUserName (userRegisterReqDTO.getUsername ())){
            return Results.failure (UserErrorCodeEnum.USER_EXIST.code (),
                    UserErrorCodeEnum.USER_NAME_EXIST.message ());
        }
        userService.register (userRegisterReqDTO);
        return Results.success ();
    }

    @GetMapping("v1/user/has-username")
    public Result hasUserName(String username) {
        return Results.success (userService.hasUserName (username));
    }

    @GetMapping("/test")
    public String test1(String userName) {
        return "asdjajsd";
    }
//    @GetMapping()
}
