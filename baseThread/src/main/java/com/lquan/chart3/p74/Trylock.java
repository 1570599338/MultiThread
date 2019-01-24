package com.lquan.chart3.p74;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName Timelock
 *
 * @Author lquan
 * @Description //tryLock锁的非限时等待
 * @Date
 * @Param
 * @return
 **/
public class Trylock implements Runnable {
    public  static ReentrantLock lock1 = new ReentrantLock();
    public  static ReentrantLock lock2 = new ReentrantLock();
    int lock;


    public Trylock(int lock) {
        this.lock = lock;
    }

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
        System.out.println(Thread.currentThread().getName()+":进入");
        if(lock==1){
            while(true){

                if(lock1.tryLock()){
                    try {
                        try {
                            System.out.println(Thread.currentThread().getName()+":获取锁1");
                            Thread.sleep(500);
                        } catch (InterruptedException e) { }

                        if(lock2.tryLock()){
                            try {
                                System.out.println(Thread.currentThread().getName()+":获取锁2");
                                return;
                            } finally {
                                lock2.unlock();
                                System.out.println(Thread.currentThread().getName()+"放弃锁2");
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }

            }

        }else {
            while(true){
                if(lock2.tryLock()){

                    try {
                        try {
                            System.out.println(Thread.currentThread().getName()+":获取锁2");
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(lock1.tryLock()){
                            try {
                                System.out.println(Thread.currentThread().getName()+":获取锁1");
                                return;
                            } finally {
                                lock1.unlock();
                                System.out.println(Thread.currentThread().getName()+"放弃锁1");
                            }
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Trylock r1 =new Trylock(1);
        Trylock r2 =new Trylock(2);
        Thread t1 = new Thread(r1,"r1-1");
        Thread t2 = new Thread(r2,"r2-2");
        t1.start();
        t2.start();
    }
}



