package main.java.com.code.one.eleven;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * ClassName BoundedResource
 *
 * @Author lquan
 * @Description //资源个数有限
 * @Date
 * @Param
 * @return
 **/
public class BoundedResource {
    /** 信号旗 **/
    private final Semaphore semaphore;
    private  final  int permits;
    private  final  static Random random = new Random(31459);

    /**
     * 构造函数（permits为资源数）
     * @param permits
     */
    public BoundedResource(int permits){
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    // 使用资源
    public void  use() throws InterruptedException {
        semaphore.acquire();// 确认是否确实存在可用资源，当所有资源都被使用时，线程会被阻塞在该方法中
        try {
            doUse();
        } finally {
            semaphore.release();// 用于释放资源
        }


    }


    /**
     * 实际使用资源（此处仅使用Thread.sleep）
     * @throws InterruptedException
     */
    protected void  doUse() throws InterruptedException {
        Log.println("BEGIN: use="+(permits-semaphore.availablePermits()));
        Thread.sleep(random.nextInt(5000));
        Log.println("END:   use="+(permits-semaphore.availablePermits()));
    }


}
