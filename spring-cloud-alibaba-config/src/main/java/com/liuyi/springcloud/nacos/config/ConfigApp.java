package com.liuyi.springcloud.nacos.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName NacosApp
 * @description：
 * @author：liuyi
 * @Date：2022/3/13 21:54
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConfigApp {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApp.class);
    }
}
