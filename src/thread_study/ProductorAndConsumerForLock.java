package thread_study;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//店员类
class Clerk {
    private int product = 0;
    private Lock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();

    public void get() {
        reentrantLock.lock();
        try {
            while (product >= 1) {
                System.out.println("库存已满");
                try {
                    //this.wait();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + ++product);
            //this.notifyAll();
            condition.signalAll();
        }finally {
            reentrantLock.unlock();
        }
    }

    public void sale() {
        reentrantLock.lock();
        try {
            while (product <= 0) {
                System.out.println("库存缺货");
                try {
                    //this.wait();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + --product);
            //this.notifyAll();
            condition.signalAll();
        }finally {
            reentrantLock.unlock();
        }
    }
}

// 生产者类
class Productor implements Runnable {

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.get();
        }
    }
}

// 消费者类
class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            clerk.sale();
        }
    }
}

public class ProductorAndConsumerForLock {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);

        new Thread(productor, "Productor A").start();
        new Thread(consumer, "Consumer B").start();
        new Thread(productor, "Productor C").start();
        new Thread(consumer, "Consumer D").start();
    }
}