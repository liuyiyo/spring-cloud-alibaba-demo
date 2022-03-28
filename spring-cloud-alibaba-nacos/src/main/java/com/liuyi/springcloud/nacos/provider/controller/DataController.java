package com.liuyi.springcloud.nacos.provider.controller;

import com.liuyi.springcloud.commons.entity.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class DataController {
    @Value("${server.port}")
    private String serverPort;

    //模仿数据库存储数据
    public static HashMap<Long,String> hashMap = new HashMap<>();
    static {
        hashMap.put(1l,"鼠标");
        hashMap.put(2l,"键盘");
        hashMap.put(3l,"耳机");
    }

    @GetMapping("info/{id}")
    public JsonResult<String> msbSql(@PathVariable("id") Long id){
        if(id<=3){
            JsonResult<String> result = new JsonResult(200,"serverPort"+serverPort+": "+hashMap.get(id));
            return result;
        }else {
            throw new NullPointerException("没有对应的数据记录");
        }
    }
}