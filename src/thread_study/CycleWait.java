package thread_study;

import java.util.concurrent.TimeUnit;

public class CycleWait implements Runnable {
    private String value;
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = "Hello Thread";
    }

    public static void main(String[] args) throws InterruptedException {
        CycleWait cycleWait = new CycleWait();
        Thread thread = new Thread(cycleWait);
        thread.start();
//        while(cycleWait.value == null){
//            TimeUnit.SECONDS.sleep(1);
//        }
        thread.join();
        System.out.println(cycleWait.value);
    }
}
