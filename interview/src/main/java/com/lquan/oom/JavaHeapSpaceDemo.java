package com.lquan.oom;

import java.util.Random;

/**
 * @program: MultiThread
 * @description: oom之java heap space 错误
 * @author: lquan
 * @create: 2022-11-16 09:24
 *
 * 配置JVM参数 -Xms10  -Xmx10m
 **/
public class JavaHeapSpaceDemo {


    public static void main(String[] args) {

        System.out.println("=====================start");
     //   byte[] bytes = new byte[11*1024*1024];

        System.out.println("=====================end");

        // 或者下面的方式也能实现
        String strs="hello World";
        while (true){
            strs = strs +"--"+ new Random().nextInt(1111111111) +"--"+ new Random().nextInt(222222222);
            strs.intern();
        }
    }
}
