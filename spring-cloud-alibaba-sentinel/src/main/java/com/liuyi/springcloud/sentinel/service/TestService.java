package com.liuyi.springcloud.sentinel.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * @ClassName TestService
 * @description：
 * @author：liuyi
 * @Date：2022/3/26 17:54
 */
@Service
public class TestService {

    @SentinelResource("test")
    public String test(){
        return "common";
    }
}
