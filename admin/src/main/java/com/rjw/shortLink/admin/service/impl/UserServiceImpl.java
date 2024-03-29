package com.rjw.shortLink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rjw.shortLink.admin.dao.entity.UserDo;
import com.rjw.shortLink.admin.dao.mapper.UserMapper;
import com.rjw.shortLink.admin.dto.req.UserRegisterReqDTO;
import com.rjw.shortLink.admin.dto.resp.UserRespDTO;
import com.rjw.shortLink.admin.service.UserService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @program: shortLink
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-23 15:40
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDo> implements UserService {
    @Resource
    private RBloomFilter<String> userRBloomFilter;
    public UserRespDTO getUserByName(String name) {

        LambdaQueryWrapper<UserDo> eq = Wrappers.lambdaQuery (UserDo.class).eq (UserDo::getUsername, name);
        UserDo one = this.getOne (eq);
        UserRespDTO user = new UserRespDTO () ;
        if(one!=null) {
            BeanUtils.copyProperties (one, user);
            return user;
        }
        return null;
    }
    public boolean hasUserName(String name){
//        LambdaQueryWrapper<UserDo> eq = Wrappers.lambdaQuery (UserDo.class).eq (UserDo::getUsername, name);
//        UserDo  one = this.getOne (eq);
        return userRBloomFilter.contains (name);
    }
    public void register(UserRegisterReqDTO userRegisterReqDTO){
        UserDo user = new UserDo ();
        BeanUtils.copyProperties (userRegisterReqDTO,user);
        this.save (user);
    }
}
