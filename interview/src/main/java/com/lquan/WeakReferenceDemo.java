package com.lquan;

import java.lang.ref.WeakReference;

/**
 * @program: MultiThread
 * @description: 弱引用
 * 弱引用需要用java.lang.ref.WeakReference类来实现，他比软引用的生存期更短。
 *
 * 对于只有弱引用的对象来说，只要垃圾回收机制一运行，不管JVM的内存空间是否足够，都会回收该对象占用的内存。
 * @author: lquan
 * @create: 2022-11-15 22:04
 **/
public class WeakReferenceDemo {
    public static void main(String[] args) {

        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);

        System.out.println(o1);
        System.out.println(weakReference.get());


        o1=null;
        System.gc();
        System.out.println("=============================");
        System.out.println(o1);
        System.out.println(weakReference.get());


    }
}
