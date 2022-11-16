package com.lquan.thread;


import java.util.concurrent.TimeUnit;

/**
 * @program: MultiThread
 * @description: 死锁问题
 * @author: lquan
 * @create: 2022-11-09 09:45
 **/
public class ThreadDemo {


    public static void main(String[] args) {
       String lockA ="lockA";
       String lockB ="lockB";

        new Thread(()->{
           synchronized (lockA){
               try{
                   Thread.sleep(3000);
               }catch (Exception e){
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName()+"\t 开始执行，获取当前锁："+lockA);
               synchronized (lockB){
                   System.out.println(Thread.currentThread().getName()+"\t 结束执行，获取当前锁："+lockB);
               }
           }

        },"T1").start();



        new Thread(()->{
            synchronized (lockB){
                try{
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t 开始执行，获取当前锁："+lockB);


                synchronized (lockA){
                    System.out.println(Thread.currentThread().getName()+"\t 结束执行，获取当前锁："+lockA);
                }
            }


        },"T2").start();



        System.out.println(Thread.currentThread().getName()+"\t **************************");
    }

}


class ClockSource{

    public int count =0;


    synchronized public void  t1(){
        aa();
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        bb();
    }

    synchronized public void  t2(){
        bb();

        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        aa();

    }

    synchronized public void  aa(){
            count ++;

        System.out.println(Thread.currentThread().getName()+"\t aaa"+count);
    }

    synchronized public void  bb(){
        count ++;
        System.out.println(Thread.currentThread().getName()+"\t bb:"+count);

    }

}
