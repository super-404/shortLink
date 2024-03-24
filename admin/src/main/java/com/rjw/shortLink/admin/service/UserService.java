package com.rjw.shortLink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rjw.shortLink.admin.dao.entity.UserDo;
import com.rjw.shortLink.admin.dto.resp.UserRespDTO;

public interface UserService extends IService<UserDo>  {
    UserRespDTO getUserByName(String name);
}
