package thread_study.synchronize;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SynchronizedDemo implements Runnable{

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if(threadName.startsWith("A")){
            async();
        }else if(threadName.startsWith("B")){
            syncObjectBlock();
        }else if(threadName.startsWith("C")){
            syncObjectMethod();
        }else if(threadName.startsWith("D")){
            syncClassBlock();
        }else if(threadName.startsWith("E")){
            syncClassMethod();
        }
    }

    private synchronized static void syncClassMethod() {
        System.out.println(Thread.currentThread().getName() + "_SyncClassMethod:" + new SimpleDateFormat("mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName() + "_SyncClassMethod_Start:" + new SimpleDateFormat("mm:ss").format(new Date()));
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + "_SyncClassMethod_End:" + new SimpleDateFormat("mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void syncClassBlock() {
        System.out.println(Thread.currentThread().getName() + "_SyncClassBlock:" + new SimpleDateFormat("mm:ss").format(new Date()));
        synchronized (SynchronizedDemo.class){
            try {
                System.out.println(Thread.currentThread().getName() + "_SyncClassBlock_Start:" + new SimpleDateFormat("mm:ss").format(new Date()));
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "_SyncClassBlock_End:" + new SimpleDateFormat("mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void async() {
        try {
            System.out.println(Thread.currentThread().getName() + "_Async_Start:" + new SimpleDateFormat("mm:ss").format(new Date()));
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + "_Async_End:" + new SimpleDateFormat("mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private synchronized void syncObjectMethod() {
        System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod:" + new SimpleDateFormat("mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod_Start:" + new SimpleDateFormat("mm:ss").format(new Date()));
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName() + "_SyncObjectMethod_End:" + new SimpleDateFormat("mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void syncObjectBlock() {
        System.out.println(Thread.currentThread().getName() + "_SyncObjectBlock:" + new SimpleDateFormat("mm:ss").format(new Date()));
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName() + "_SyncObjectBlock_Start:" + new SimpleDateFormat("mm:ss").format(new Date()));
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "_SyncObjectBlock_End:" + new SimpleDateFormat("mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}