package com.liuyi.springcloud.openfign.consumer.controller;

import com.liuyi.springcloud.commons.entity.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OpenFeignTestController
 * @description：
 * @author：liuyi
 * @Date：2022/3/15 11:17
 */
@RestController
public class OpenFeignTestController {

    @Autowired
    private FeignClientDemo feignClientDemo;

    @GetMapping("consumer/test")
    public String echoAppName(){
        return feignClientDemo.getServerPort();
    }

    @GetMapping("getInfo/{id}")
    public JsonResult<String> getInfo(@PathVariable("id")Long id){
        return feignClientDemo.msbSql(id);
    }
}
