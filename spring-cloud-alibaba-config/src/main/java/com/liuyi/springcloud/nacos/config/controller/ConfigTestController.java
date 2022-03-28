package com.liuyi.springcloud.nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ConfigTestController
 * @description：
 * @author：liuyi
 * @Date：2022/3/15 22:43
 */
@RestController
@RefreshScope
public class ConfigTestController {

    @Value("${app.user.name}")
    private String userName;

    @Value("${app.user.pwd}")
    private String pwd;

    @GetMapping("/getUserName")
    public String getUserName(){
        return "userName======="+userName+"pwd===="+pwd;
    }

}
