package com.liuyi.springcloud.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liuyi.springcloud.sentinel.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SentinelTestController
 * @description：
 * @author：liuyi
 * @Date：2022/3/17 14:41
 */
@RestController
@Slf4j
public class SentinelTestController {

    @Autowired
    private TestService testService;

    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName() + "testA");
        return testService.test();
    }

    @GetMapping("/testB")
    public String testB() {
        return testService.test();
    }

    @GetMapping("/testC")
    public String testC() {
        try {
            log.info(Thread.currentThread().getName() + "testC");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------------------testC";
    }

    @GetMapping("/testD")
    public String testD(Integer id) {
        if (id != null && id > 1) {
            throw new RuntimeException("异常比例测试");
        }
        return "------------------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "handler_HotKey")
    public String testHotKey(@RequestParam(value = "hot1",required = false) String hot1,
                             @RequestParam(value = "hot2",required = false)String hot2,
                             @RequestParam(value = "hot3",required = false) String hot3){
        return "----testHotKey";
    }

    //处理异常方法，方法签名要和对应的接口方法保持一致
    public String handler_HotKey(String hot1, String hot2, String hot3, BlockException exception){
        return "系统繁忙稍后重试。。";
    }

}
