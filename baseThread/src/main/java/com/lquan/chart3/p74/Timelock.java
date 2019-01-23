package com.lquan.chart3.p74;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * ClassName Timelock
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class Timelock implements Runnable {
    public  static ReentrantLock lock = new ReentrantLock();


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            System.out.println("lock:" + Thread.currentThread().getName());
            if (lock.tryLock(5, TimeUnit.SECONDS)){
                Thread.sleep(6000);
            }else{
                System.out.println("get lock failed" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) {
        Timelock tl =new Timelock();
        Thread t1 = new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
    }
}



