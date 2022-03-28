package com.liuyi.springcloud.nacos.provider8084;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName NacosApp
 * @description：
 * @author：liuyi
 * @Date：2022/3/13 21:54
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider8084App {
    public static void main(String[] args) {
        SpringApplication.run(Provider8084App.class);
    }
}
