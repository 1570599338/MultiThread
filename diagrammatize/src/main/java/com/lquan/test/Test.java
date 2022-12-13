package com.lquan.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: MultiThread
 * @description:
 * @author: lquan
 * @create: 2022-11-01 11:06
 **/

class  ShareDate{
    private  int num =1;
    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 =  lock.newCondition();
    private Condition c2 =  lock.newCondition();
    private Condition c3 =  lock.newCondition();

    public  void  print5(){
        lock.lock();
        try {
            while(num!=1){
                c1.await();
            }
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName()+" \t :"+i);
            }
            num=2;
            c2.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }


    public  void  print10(){
        lock.lock();
        try {
            while(num!=2){
                c2.await();
            }
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+" \t :"+i);
            }
            num=3;
            c3.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public  void  print15(){
        lock.lock();
        try {
            while(num!=3){
                c3.await();
            }
            for (int i = 0; i <15 ; i++) {
                System.out.println(Thread.currentThread().getName()+" \t :"+i);
            }
            System.out.println("------------------------------------------------------");
            num=1;
            c1.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

}

public class Test {

    public static void main(String[] args){

        ShareDate shareDate = new ShareDate();

        System.out.println("****************************");
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                shareDate.print5();
            }

        },"A").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                shareDate.print10();
            }

        },"B").start();


        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                shareDate.print15();
            }

        },"C").start();

     //   System.out.println("+++++++++++++++++++++++++");


    }
}
