package com.lquan.chart3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName ReenterLock
 *
 * @Author lquan
 * @Description //重入锁
 * @Date
 * @Param
 * @return
 **/
public class ReenterLock implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i=0;


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
        for (int j = 0; j <100000000 ; j++) {
            lock.lock();
            lock.lock();
            try{
                i++;
            }finally {
                lock.unlock();
                lock.unlock();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock tl = new ReenterLock();
        Thread t1= new Thread(tl);
        Thread t2 = new Thread(tl);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("**" + i);

    }
}
