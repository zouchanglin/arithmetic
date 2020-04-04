//package thread_study;
//
////店员类
//class Clerk {
//    private int product = 0;
//
//    public synchronized void get() {
//        while (product >= 1) {
//            System.out.println("库存已满");
//
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + ":" + ++product);
//        this.notifyAll();
//    }
//
//    public synchronized void sale() {
//        while (product <= 0) {
//            System.out.println("库存缺货");
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Thread.currentThread().getName() + ":" + --product);
//        this.notifyAll();
//    }
//}
//
//// 生产者类
//class Productor implements Runnable {
//
//    private Clerk clerk;
//
//    public Productor(Clerk clerk) {
//        this.clerk = clerk;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            clerk.get();
//        }
//    }
//}
//
//// 消费者类
//class Consumer implements Runnable {
//
//    private Clerk clerk;
//
//    public Consumer(Clerk clerk) {
//        this.clerk = clerk;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            clerk.sale();
//        }
//    }
//}
//
//public class ProductorAndConsumer {
//
//    public static void main(String[] args) {
//        Clerk clerk = new Clerk();
//
//        Productor productor = new Productor(clerk);
//        Consumer consumer = new Consumer(clerk);
//
//        new Thread(productor, "Productor A").start();
//        new Thread(consumer, "Consumer B").start();
//        new Thread(productor, "Productor C").start();
//        new Thread(consumer, "Consumer D").start();
//    }
//}