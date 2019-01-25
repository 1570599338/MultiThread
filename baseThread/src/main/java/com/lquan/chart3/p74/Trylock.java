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
        System.out.println(Thread.currentThread().getName()+":准备");
        if(lock==1){
            while(true){
                System.out.println(Thread.currentThread().getName()+":进入-1");
                if(lock1.tryLock()){
                    try {
                        try {
                            System.out.println(Thread.currentThread().getName()+":获取锁1-1");
                            Thread.sleep(500);
                        } catch (InterruptedException e) { }

                        if(lock2.tryLock()){
                            try {
                                System.out.println(Thread.currentThread().getName()+":获取锁2-return-1");
                                return;
                            } finally {
                                lock2.unlock();
                                System.out.println(Thread.currentThread().getName()+"结束释放锁2-1");
                            }
                        }else{
                            System.out.println(Thread.currentThread().getName()+"获取锁2失败-1");
                        }
                    } finally {
                        lock1.unlock();
                        System.out.println(Thread.currentThread().getName()+":结束释放锁1-1");
                    }
                }else{
                    System.out.println(Thread.currentThread().getName()+"获取锁1失败-1");
                }

            }

        }else {
            while(true){
                System.out.println(Thread.currentThread().getName()+":2进入-2");
                if(lock2.tryLock()){

                    try {
                        try {
                            System.out.println(Thread.currentThread().getName()+":获取锁2-2");
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(lock1.tryLock()){
                            try {
                                System.out.println(Thread.currentThread().getName()+":获取锁1-return-2");
                                return;
                            } finally {
                                lock1.unlock();
                                System.out.println(Thread.currentThread().getName()+"结束释放锁1-2");
                            }
                        }else{
                            System.out.println(Thread.currentThread().getName()+"获取锁1失败-2");
                        }
                    } finally {
                        lock2.unlock();
                        System.out.println(Thread.currentThread().getName()+"结束释放锁2-2");
                    }
                }else{
                    System.out.println(Thread.currentThread().getName()+"获取锁2失败-2");
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
            Trylock r1 =new Trylock(1);
            Trylock r2 =new Trylock(2);
            Thread t1 = new Thread(r1,"r1-1");
            Thread t2 = new Thread(r2,"r2-2");
            t1.start();
            t2.start();
           // t1.join();
           // t2.join();
    }
}



