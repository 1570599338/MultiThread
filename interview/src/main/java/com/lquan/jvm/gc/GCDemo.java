package com.lquan.jvm.gc;

import java.util.Random;

/**
 * @program: MultiThread
 * @description:
 * @author: lquan
 * @create: 2022-11-17 20:12
 *
 *
 * 1、 -Xms10m  -Xmx10m  -XX:+PrintGCDetails  -XX:+PrintCommandLineFlages  -XX:+UseSerialGC    (DefNew + Tenured)
 *
 * 2、 -Xms10m  -Xmx10m  -XX:+PrintGCDetails  -XX:+PrintCommandLineFlages  -XX:+UseParNewGC     (ParNew + Tenured)
 *
 *  备注：Java hotspot（TM）64-Bit  Server VM Warning:
 *         Using the ParNew young collector with the Serial old collector is deprecated
 *         and will likely be removed in a future release
 *
 *
 * 3、 -Xms10m  -Xmx10m  -XX:+PrintGCDetails  -XX:+PrintCommandLineFlages  -XX:+UseParallelGC    (PSYoungGen +ParOldGen)
 *
 *
 * 4、
 *   a、 -Xms10m  -Xmx10m  -XX:+PrintGCDetails  -XX:+PrintCommandLineFlages  -XX:+UseParallelOldGC    (PSYoungGen +ParOldGen)
 *
 *   b、不加就是默认useParallelGC
 *   -Xms10m  -Xmx10m  -XX:+PrintGCDetails  -XX:+PrintCommandLineFlages  -XX:+UseParallelOldGC    (PSYoungGen +ParOldGen)
 *
 *
 *  5、 -Xms10m  -Xmx10m  -XX:+PrintGCDetails  -XX:+PrintCommandLineFlages  -XX:+UseConcMarkSweepGC      (parnew generation+concurrent1
 *
 *  6、-Xms10m  -Xmx10m  -XX:+PrintGCDetails  -XX:+PrintCommandLineFlages    -XX:+UseG1GC                 后面单独讲解G1
 *
 *
 * 7、（理论知道即可，实际中已经被优化掉了，没有了）
 *  -Xms10m  -Xmx10m  -XX:+PrintGCDetails  -XX:+PrintCommandLineFlages   -XX:+UseSerialOldGC
 *
 *
 **/
public class GCDemo {

    public static void main(String[] args) {
        try {
            // 或者下面的方式也能实现
            String strs="hello";
            while (true){
                strs = strs +"--"+ new Random().nextInt(77777) +"--"+ new Random().nextInt(888888);
                strs.intern();
            }


        }catch (Exception e){

        }
    }

}
