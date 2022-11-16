package com.lquan.oom;

/**
 * @program: MultiThread
 * @description: StackOverflowError栈发生异常错误
 *
 *              默认情况下线程中的栈的大小在是512k~1024k之间
 *
 * @author: lquan
 * @create: 2022-11-16 08:51
 **/
public class StackOverflowErrorDemo {

    public static void main(String[] args) {

        stackoverflowerrorFun();

    }

    public static  void stackoverflowerrorFun(){
        stackoverflowerrorFun();
    }

}
