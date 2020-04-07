package thread_study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        //只能5个线程同时访问
        Semaphore semaphore = new Semaphore(5);
        //模拟20个客户端访问
        for (int i = 0; i < 20; i++) {
            final int NO = i;
            pool.execute(()->{
                try {
                    //获取许可
                    semaphore.acquire();
                    System.out.println("Accessing: " + NO);
                    Thread.sleep((long)(Math.random() * 10000));
                    //访问完毕后释放
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //退出线程池
        pool.shutdown();
    }
}
