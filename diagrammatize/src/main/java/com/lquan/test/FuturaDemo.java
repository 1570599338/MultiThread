package com.lquan.test;

import java.util.concurrent.*;

/**
 * @program: MultiThread
 * @description:
 * @author: lquan
 * @create: 2022-11-01 20:28
 **/
public class FuturaDemo {

    public static void main(String[] args) throws Exception {
        FutureTask futureTask= new FutureTask<String>(()->{

            return "你好 ！"+Integer.MAX_VALUE;
        });
        new Thread(futureTask).start();

        System.out.println(" hello:"+futureTask.get());


        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        ExecutorService executorService3 = Executors.newCachedThreadPool();




    }




}
