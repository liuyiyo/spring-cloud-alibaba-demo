package com.liuyi.springcloud.nacos.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName NacosTestController
 * @description：
 * @author：liuyi
 * @Date：2022/3/13 22:15
 */
@RestController
public class ConsumerTestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("consumer/test")
    public String echoAppName(){

        String path = "http://service-provider/getServerPort";
        System.out.println("request path:" +path);
        return restTemplate.getForObject(path,String.class);
    }

}
