package com.lquan.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: MultiThread
 * @description:
 * @author: lquan
 * @create: 2022-11-16 19:56
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 *
 * GC 回收时间过长会抛出OutofMemory,过长的定义是，超过98%的时间用来做GC并且回收了不到2%的堆内存
 * 连续多次GC都只回收了不到2%的极端情况下才会抛出。假如不抛出GC overhead limit  错误会发生什么情况呢？
 * cpu使用率一直是100%，而GC却没有任何成果。
 *
 **/
public class GCOverheadDemo {

    public static void main(String[] args) {

        int i=0;
        List<String> list = new ArrayList<>();
        try{
            while(true){
                list.add(String.valueOf(++i).intern());
            }
        }catch (Throwable e){
            System.out.println("*****************"+i);
            e.printStackTrace();

        }

    }
}
