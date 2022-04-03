package com.liuyi.springcloud.commons.demo.csv;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

// lombok注解
@Data
public class TestBean{
    // 如果csv中标题与字段不对应，可以使用alias注解设置别名
    @Alias("姓名")
    private String name;
    private String gender;
    private String focus;
    private Integer age;
}