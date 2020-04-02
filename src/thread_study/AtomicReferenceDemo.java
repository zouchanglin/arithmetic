package thread_study;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set("AAA");
        //CAS操作更新
        boolean result = atomicReference.compareAndSet("AAA", "BBB");
        System.out.println(result + " " + atomicReference.get());

        //CAS操作更新
        result = atomicReference.compareAndSet("AAA", "CCC");
        System.out.println(result + " " + atomicReference.get());
    }
}
