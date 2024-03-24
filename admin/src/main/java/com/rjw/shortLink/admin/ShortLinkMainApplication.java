package com.rjw.shortLink.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: shortLink
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-23 14:08
 **/
@SpringBootApplication
@MapperScan("com.rjw.shortLink.admin.dao.mapper")
public class ShortLinkMainApplication {
    public static void main(String[] args) {
        SpringApplication.run (ShortLinkMainApplication.class);
    }
}
