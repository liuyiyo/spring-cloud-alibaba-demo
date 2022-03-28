package com.liuyi.springcloud.nacos.config.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @InterfaceName FeignClient
 * @description：
 * @author：liuyi
 * @Date：2022/3/15 11:12
 */
@FeignClient("service-provider")
public interface FeignClientDemo {
    @GetMapping(value = "getServerPort")
    public String getServerPort();
}
