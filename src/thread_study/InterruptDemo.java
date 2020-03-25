package thread_study;

public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = ()->{
            int i = 0;
            try{
                while (!Thread.currentThread().isInterrupted()){
                    Thread.sleep(100);
                    i++;
                    System.out.println(Thread.currentThread().getName() + " (" +
                            Thread.currentThread().getState()+") loop " + i);
                }
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName() + " (" +
                        Thread.currentThread().getState()+") catch InterruptedException");
            }
        };

        Thread t1 = new Thread(task, "T1");
        System.out.println(t1.getName() + " (" + t1.getState() + ") is new.");

        t1.start();
        System.out.println(t1.getName() + " (" + t1.getState() + ") is started.");

        Thread.sleep(300);
        t1.interrupt();
        System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted.");

        Thread.sleep(300);
        System.out.println(t1.getName() + " (" + t1.getState() + ") is interrupted now.");
    }
}
