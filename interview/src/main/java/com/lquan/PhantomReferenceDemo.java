package com.lquan;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

/**
 * 虚引用
 * java 提供了4中引用类型，在垃圾回收的时候，都有自己各自的特点。
 * ReferenceQueue是用来配合引用工作的，没有ReferenceQueue一样可以运行。
 *
 * 创建引用的时候可以指定关联的队列，当GC释放对象内存的时候，会讲引用加入到引用队列，
 * 如果程序发现某个虚拟引用已经被加入到引用队列，那么就可以在所引用的对象的内存被回收之前采取必要的行动
 * 相当于是一种通知机制。
 *
 * 当关联的引用队列有数据的时候，以为软引用指向的对内存中的对象被回收，通过这种方式，JVM允许我们在对象被销毁后做一些我们自己想做的事情。
 */
public class PhantomReferenceDemo {

    public static void main(String[] args) throws  Exception {
        Object o1 =new Object();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference<Object> reference = new PhantomReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(reference.get());//虚引用PhantomReference的get方法总是null
        System.out.println(referenceQueue.poll());

        o1=null;
        System.out.println("===========================");
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(o1);
        System.out.println(reference.get());
        Reference re =referenceQueue.poll();
        System.out.println(re);

    }
}
