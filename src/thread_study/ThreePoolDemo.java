package thread_study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreePoolDemo {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Future<String> futureTask = cachedThreadPool.submit(new MyCallable());
        if(!futureTask.isDone()){
            System.out.println("Task is not finished, please wait!");
        }
        try {
            System.out.println(futureTask.get());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            cachedThreadPool.shutdown();
        }
    }
}