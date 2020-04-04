package thread_study;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//线程交替执行
public class ThreadAlternate {
    public static void main(String[] args) {
        ThreadAlternateRun alternateRun = new ThreadAlternateRun();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                alternateRun.loopA(i);
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                alternateRun.loopB(i);
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                alternateRun.loopC(i);
                System.out.println("---------------------------------");
            }
        }, "C").start();
    }
}

class ThreadAlternateRun{
    private int position = 1;
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void loopA(int round){
        lock.lock();
        try{
            //判断
            if(position != 1){
                try {
                    conditionA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //打印
            for (int i = 1; i <=3 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + round);
            }

            //唤醒
            position = 2;
            conditionB.signal();
        }finally {
            lock.unlock();
        }
    }

    public void loopB(int round){
        lock.lock();
        try{
            //判断
            if(position != 2){
                try {
                    conditionB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //打印
            for (int i = 1; i <=3 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + round);
            }

            //唤醒
            position = 3;
            conditionC.signal();
        }finally {
            lock.unlock();
        }
    }

    public void loopC(int round){
        lock.lock();
        try{
            //判断
            if(position != 3){
                try {
                    conditionC.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //打印
            for (int i = 1; i <=3 ; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\t" + round);
            }

            //唤醒
            position = 1;
            conditionA.signal();
        }finally {
            lock.unlock();
        }
    }
}
