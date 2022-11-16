package com.lquan.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @program: MultiThread
 * @description:
 * @author: lquan
 * @create: 2022-11-16 22:00
 *
 * JVM参数
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MetaspaceSize=5m -XX:MaxMetaspaceSize=5m
 *
 * Java8及之后的版本使用Metaspace来代替永久代。
 *
 * Metaspace是方法区在Hotspot中的实现，它与持久带最大的区别在于：Metaspace并不在虚拟机内存中而是使用本地内存
 * 也即在java8中，class metadata（the virtual internal presentation of java class），被存储在叫做
 * Metaspace的Native memory
 *
 * 永久代（java8后被元元空间Metaspace取代了）存放了一下信息：
 *      虚拟机加载的类信息
 *      常量池
 *      静态变量
 *      即时编译后的代码
 *
 *
 * 模拟Metaspace空间溢出，我们不断生产类往元空间灌，类占据的空间总是会超过Metaspace指定的空间大小的
 *
 *
 *
 **/
public class MetaSpaceOOMDemo {

    static class OOMTets{}

    public static void main(String[] args) {
        int i=0;

        try {
            while (true){

                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTets.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,args );
                    }
                });
                enhancer.create();
            }

        }catch (Throwable e){
            System.out.println("*****************"+i);
            e.printStackTrace();

        }

    }
}
