package com.liuyi.springcloud.commons.demo.csv;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;

import java.net.URL;
import java.util.List;

/**
 * @ClassName CSVDemo
 * @description：
 * @author：liuyi
 * @Date：2022/4/3 22:07
 */
public class CSVDemo {
    public static void main(String[] args) {
//        //指定路径和编码
//        CsvWriter writer = CsvUtil.getWriter("F:/testWrite.csv", CharsetUtil.CHARSET_UTF_8);
//        //按行写出
//        writer.write(
//                new String[] {"a1", "b1", "c1"},
//                new String[] {"a2", "b2", "c2"},
//                new String[] {"a3", "b3", "c3"}
//        );
//        URL resource = ResourceUtil.getResource("");
//        System.out.println(resource.getPath());


        CsvReader reader = CsvUtil.getReader();
        //假设csv文件在classpath目录下
        List<TestBean> result = reader.read(ResourceUtil.getUtf8Reader("test_bean.csv"), TestBean.class);
        System.out.println(result);
    }
}
