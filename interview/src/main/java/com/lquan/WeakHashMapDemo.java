package com.lquan;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @program: MultiThread
 * @description:
 * @author: lquan
 * @create: 2022-11-15 22:26
 **/
public class WeakHashMapDemo {

    public static void main(String[] args) {
        hashmapfun();
        System.out.println("===========================");
        weakHashmapfun();
    }


    public static  void  weakHashmapfun(){
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value ="WeakHashMap";

        map.put(key,value);
        System.out.println("-->"+map);


        key=null;
        System.out.println("-->"+map);

        System.gc();
        System.out.println("-->"+map+"\t"+map.size());

    }

    public static  void  hashmapfun(){
        Map<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value ="HashMap";

        map.put(key,value);

        System.out.println(map);


        key=null;
        System.out.println(map);

        System.gc();
        System.out.println(map+"\t"+map.size());

    }
}
