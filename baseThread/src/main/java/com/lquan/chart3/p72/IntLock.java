package com.lquan.chart3.p72;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName IntLock
 *
 * @Author lquan
 * @Description // 中断响应
 * @Date
 * @Param
 * @return
 **/
public class IntLock implements  Runnable{
    public  static ReentrantLock lock1 = new ReentrantLock();
    public  static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    /**
     * 控制加锁顺序，方便构造思索
     * @param lock
     */
    public IntLock(int lock){
        this.lock=lock;
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
        try {
            if (lock==1){
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                        lock2.lockInterruptibly();

                }
            }else {
                lock2.lockInterruptibly();

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        lock1.lockInterruptibly();
                    }

            }

        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId()+":线程退出");
        }

    }


    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        // 中断其中一个线程
        t2.interrupt();

    }






}
