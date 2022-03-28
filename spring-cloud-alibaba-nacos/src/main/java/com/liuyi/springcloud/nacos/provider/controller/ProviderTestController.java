package com.liuyi.springcloud.nacos.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName NacosTestController
 * @description：
 * @author：liuyi
 * @Date：2022/3/13 22:15
 */
@RestController
public class ProviderTestController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "getServerPort")
    public String getServerPort() {
        return "Hello consumer,provider serverPort==== " + serverPort;
    }

}
