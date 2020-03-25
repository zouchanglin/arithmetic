package thread_study;

import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallable());
        Thread thread = new Thread(futureTask);
        thread.start();
        if(!futureTask.isDone()){
            System.out.println("Task is not finished, please wait!");
        }
        System.out.println("task return: " + futureTask.get());
    }
}
