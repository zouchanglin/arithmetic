package thread_study;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("AAA", "BBB", "CCC");
        List<String> list2 = Arrays.asList("DDD", "EEE", "FFF");
        List<String> list3 = Arrays.asList("GGG", "HHH", "III");

        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(()->{
            for (String string: list1) {
                System.out.println(Thread.currentThread().getName() + ":" + string);
            }
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            for (String string: list2) {
                System.out.println(Thread.currentThread().getName() + ":" + string);
            }
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            for (String string: list3) {
                System.out.println(Thread.currentThread().getName() + ":" + string);
            }
            countDownLatch.countDown();
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Print Task Finish！");
    }
}
