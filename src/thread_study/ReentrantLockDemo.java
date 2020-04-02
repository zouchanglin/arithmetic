package thread_study;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo implements Runnable{
    private static ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo lockDemo = new ReentrantLockDemo();
        Thread thread1 = new Thread(lockDemo, "Thread1");
        Thread thread2 = new Thread(lockDemo, "Thread2");
        thread1.start();
        thread2.start();
    }
}
