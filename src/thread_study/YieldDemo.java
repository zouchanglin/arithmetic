package thread_study;

public class YieldDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + i);
                if(i == 5){
                    Thread.yield();
                }
            }
        };
        new Thread(runnable, "A").start();
        new Thread(runnable, "B").start();
    }
}
