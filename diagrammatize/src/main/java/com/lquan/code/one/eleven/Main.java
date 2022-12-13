package com.lquan.code.one.eleven;

/**
 * ClassName Main
 *
 * @Author lquan
 * @Description // 测试主方法
 * @Date
 * @Param
 * @return
 **/
public class Main {
    public static void main(String[] args) {
        BoundedResource resource = new BoundedResource(3);
        for (int i = 0; i < 10; i++) {

            new UserThread(resource).start();

        }
    }
}
