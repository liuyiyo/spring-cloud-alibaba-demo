package com.liuyi.springboot.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName test
 * @description：
 * @author：liuyi
 * @Date：2022/4/7 23:55
 */
@SpringBootTest
public class Springtest {
    /**
     * @Author liuyi
     * @Description
     * @Date 2022/4/17 15:50
     **/
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        Long size = redisTemplate.opsForSet().size("");
        System.out.println(size);
    }
}
