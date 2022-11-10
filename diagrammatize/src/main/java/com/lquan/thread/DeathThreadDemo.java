package com.lquan.thread;

/**
 * @program: MultiThread
 * @description: 死锁案例
 * 死锁是指两个或两个以上的进程在执行过程中，
 * 因为争夺资源而造成的一种互相等待的现象，若
 * 无外力干预那么他们都将无法推进下去。
 *
 *
 *
 * @author: lquan
 * @create: 2022-11-09 10:43
 **/
public class DeathThreadDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Thread t1 = new Thread() {
            public void run() {
                synchronized (o1) {
                    try {
                        sleep(1000);//等待t2线程上好他的o2锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {
                        System.out.println(1);
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                synchronized (o2) {
                    try {
                        sleep(1000);//等待t1线程上好他的o1锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1) {
                        System.out.println(2);
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }


}
