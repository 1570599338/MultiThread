package com.lquan.oom;

import sun.misc.VM;

import java.nio.ByteBuffer;

/**
 * @program: MultiThread
 * @description:
 * @author: lquan
 * @create: 2022-11-16 20:49
 *
 * 配置参数
 *  -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 *
 *导致原因：
 *  写NIO程序经常使用ByteBuffer来读取或者写入数据，这是一种基于通道（channel）与缓存区（Buffer)的I/O方式
 *  它可以使用Native函数库直接分配对外内存，然后通过一个存储在Java堆里面的DirectByteBuffer对象作为这块内存的引用进行操作。
 *  这样能在一些场景中显著提升高性能，因为避免了在Java堆和Native堆中来回复制数据
 *
 *  ByteBuffer.allocate(capability)  第一种方式是分配JVM堆内存，属于GC管理范围，由于需要拷贝所以速度相对比较慢
 *
 *  ByteBuffer.allocateDirect(capability) 第二种上市分配OS本地内存，不属于GC管理范围，由于不属于JVM内存拷贝所以速度相对较快。
 *
 *  但如果不断分配本地内存，堆内存很少使用，那么JVM就不需要执行GC，DirectByteBuffer对象就不会被回收，
 *  这时候堆内存充足，但本地内存可能已经使用光了，再次尝试分配本地内存就会OutOfMemoryError，那程序就直接崩溃了。
 *
 **/
public class DirectBufferMemoryDemo {

    public static void main(String[] args) {

        System.out.println("maxDirectMemory:"+(VM.maxDirectMemory()/(double)1027/1024)+"MB");

        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        // -XX:MaxDirectMemorySize=5m  我们配置为5MB，但是实际配置使用的6MB，故意使坏
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(6*1024*1024);

        /**
         * JVM配置参数：-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
        ByteBuffer byteBuffer = ByteBuffer.allocate(11*1024*1024);

        异常： Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

         **/
    }
}
