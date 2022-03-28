package com.liuyi.springcloud.openfign.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OpenfignApp
 * @description：
 * @author：liuyi
 * @Date：2022/3/15 11:01
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OpenfeignApp {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignApp.class);
    }

}
