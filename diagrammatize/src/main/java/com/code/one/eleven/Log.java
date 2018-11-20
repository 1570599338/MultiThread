package main.java.com.code.one.eleven;

/**
 * ClassName Log
 *
 * @Author lquan
 * @Description //TODO
 * @Date
 * @Param
 * @return
 **/
public class Log {
    public static void println(String s){
        System.out.println(Thread.currentThread().getName()+"s:  " + s + "");
    }
}
