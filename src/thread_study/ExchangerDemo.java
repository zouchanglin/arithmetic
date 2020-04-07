package thread_study;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        threadPool.execute(()->{
            try {
                //男生对女生说的话
                String girl = exchanger.exchange("我其实暗恋你很久了....");
                System.out.println("女生说: " + girl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.execute(()->{
            try {
                System.out.println("女生慢慢的从教室走出来.... ");
                TimeUnit.SECONDS.sleep(3);
                //男生对女生说的话
                String boy = exchanger.exchange("我很喜欢你....");
                System.out.println("男生说：" + boy);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadPool.shutdown();
    }
}