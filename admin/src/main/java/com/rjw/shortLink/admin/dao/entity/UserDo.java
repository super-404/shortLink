package com.rjw.shortLink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @program: shortLink
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-23 15:29
 **/
@Data
@TableName("t_user")
public class UserDo {
    private Integer id;
    @TableField("username")
    private String username;
    private String password;
    private String realName;
    private String phone;
    private String mail;
    private Integer  deletionTime;
    private Date createTime;
    private Date  updateTime;
    private Integer delFlag;
}
