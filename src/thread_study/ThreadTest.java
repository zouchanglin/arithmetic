package thread_study;

public class ThreadTest {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).run();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
