package thread_study;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//读写锁
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWriteLockDemo writeLockDemo = new ReadWriteLockDemo();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                writeLockDemo.set(i);
            }
        }, "Write Thread").start();
        for (int i = 0; i < 20; i++) {
            new Thread(writeLockDemo::get, "Read Thread").start();
        }
    }
}

class ReadWriteLockDemo{
    private int number = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void get(){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + " : " + number);
        }finally {
            lock.readLock().unlock();
        }
    }

    public void set(int number){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        }finally {
            lock.writeLock().unlock();
        }
    }
}