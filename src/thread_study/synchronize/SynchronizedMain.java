package thread_study.synchronize;

public class SynchronizedMain {
    public static void main(String[] args) {
        //SynchronizedDemo demo = new SynchronizedDemo();
        Thread A_thread1 = new Thread(new SynchronizedDemo(), "A_thread1");
        Thread A_thread2 = new Thread(new SynchronizedDemo(), "A_thread2");
        Thread B_thread1 = new Thread(new SynchronizedDemo(), "B_thread1");
        Thread B_thread2 = new Thread(new SynchronizedDemo(), "B_thread2");
        Thread C_thread1 = new Thread(new SynchronizedDemo(), "C_thread1");
        Thread C_thread2 = new Thread(new SynchronizedDemo(), "C_thread2");
        Thread D_thread1 = new Thread(new SynchronizedDemo(), "D_thread1");
        Thread D_thread2 = new Thread(new SynchronizedDemo(), "D_thread2");
        Thread E_thread1 = new Thread(new SynchronizedDemo(), "E_thread1");
        Thread E_thread2 = new Thread(new SynchronizedDemo(), "E_thread2");

        A_thread1.start();
        A_thread2.start();

        B_thread1.start();
        B_thread2.start();
        C_thread1.start();
        C_thread2.start();

        D_thread1.start();
        D_thread2.start();
        E_thread1.start();
        E_thread2.start();
    }
}
