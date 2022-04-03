package com.liuyi.springcloud.openfign.consumer.controller;

import com.liuyi.springcloud.commons.entity.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("info/{id}")
    public JsonResult<String> msbSql(@PathVariable("id") Long id);
}
