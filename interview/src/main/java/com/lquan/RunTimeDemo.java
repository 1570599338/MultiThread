package com.lquan;

/**
 * @program: MultiThread
 * @description: 运行时环境
 * @author: lquan
 * @create: 2022-11-15 08:56
 **/
public class RunTimeDemo {


    public static void main(String[] args) {

        // f返回java虚拟机中的内存总容量
        long totalMemory = Runtime.getRuntime().totalMemory();
        // 返回Java虚拟机试图使用的最大内存容量
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("TOTAL_MEMORY(-Xms"+totalMemory+"(字节)、"+(totalMemory/(double)1024/1024)+"MB");
        System.out.println("MAX_MEMORY(-Xmx"+maxMemory+"(字节)、"+(maxMemory/(double)1024/1024)+"MB");

    }
}
