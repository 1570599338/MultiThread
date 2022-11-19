package com.lquan.jvm.gc;

import java.util.Random;

/**
 * @program: MultiThread
 * @description: G1垃圾收集器的demo
 * @author: lquan
 * @create: 2022-11-20 00:07
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseG1GC
 *
 **/
public class G1Demo {

    public static void main(String[] args) {
        // 或者下面的方式也能实现
        String strs="hello";
        while (true){
            strs = strs +"--"+ new Random().nextInt(77777) +"--"+ new Random().nextInt(888888);
            strs.intern();
        }

    }
}
