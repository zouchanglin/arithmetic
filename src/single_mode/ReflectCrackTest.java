package single_mode;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ReflectCrackTest {
    public static void testAbsoluteSingleSafe() throws Exception {
        System.out.println(AbsoluteSingleSafe.ONLY_ONE_SINGLE == AbsoluteSingleSafe.ONLY_ONE_SINGLE);
        //true

        Class<AbsoluteSingleSafe> absoluteSingleSafeClass = AbsoluteSingleSafe.class;
        Constructor<AbsoluteSingleSafe> constructor = absoluteSingleSafeClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        System.out.println(constructor.newInstance(null) == constructor.newInstance(null));
        //Exception in thread "main" java.lang.NoSuchMethodException: single.AbsoluteSingleSafe.<init>()
    }

    public static void testLazyTypeSingleSafeInnerClass() throws Exception {
        System.out.println(LazyTypeSingleSafeInnerClass.getInstance() == LazyTypeSingleSafeInnerClass.getInstance());
        //true
        Class<LazyTypeSingleSafeInnerClass> innerClassClass = LazyTypeSingleSafeInnerClass.class;
        Constructor<LazyTypeSingleSafeInnerClass> constructor = innerClassClass.getDeclaredConstructor(null);
        constructor.setAccessible(true);

        System.out.println(constructor.newInstance(null) == constructor.newInstance(null));
        //false
    }

    public static void threadEnvTest() throws InterruptedException {
        Set<LazyTypeSingleNoSafe> typeSingleNoSafeList = new HashSet<>();

        AtomicInteger atomicInteger = new AtomicInteger(0);

        while(atomicInteger.getAndSet(atomicInteger.intValue() + 1) < 50){
            new Thread(()->{
                LazyTypeSingleNoSafe instance = LazyTypeSingleNoSafe.getInstance();
                typeSingleNoSafeList.add(instance);
            }).start();
        }

        for(LazyTypeSingleNoSafe lazyTypeSingleNoSafe: typeSingleNoSafeList){
            System.out.println(lazyTypeSingleNoSafe);
        }
        //single.LazyTypeSingleNoSafe@6e5802d8
        //single.LazyTypeSingleNoSafe@6706a70b
        //single.LazyTypeSingleNoSafe@51a22f1d
    }

    public static void threadEnvTest2() throws InterruptedException {
        Set<LazyTypeSingleSafeInnerClass> lazyTypeSingleSafeInnerClassSet = new HashSet<>();

        AtomicInteger atomicInteger = new AtomicInteger(0);

        while(atomicInteger.getAndSet(atomicInteger.intValue() + 1) < 50){
            new Thread(()->{
                LazyTypeSingleSafeInnerClass instance = LazyTypeSingleSafeInnerClass.getInstance();
                lazyTypeSingleSafeInnerClassSet.add(instance);
            }).start();
        }

        for(LazyTypeSingleSafeInnerClass lazyTypeSingleNoSafe: lazyTypeSingleSafeInnerClassSet){
            System.out.println(lazyTypeSingleNoSafe);
        }
        //single.LazyTypeSingleNoSafe@6e5802d8
        //single.LazyTypeSingleNoSafe@6706a70b
        //single.LazyTypeSingleNoSafe@51a22f1d
    }


    public static void threadEnvTest3() throws InterruptedException {
        Set<LazyTypeSingleSafe> lazyTypeSingleSafeHashSet = new HashSet<>();

        AtomicInteger atomicInteger = new AtomicInteger(0);

        while(atomicInteger.getAndSet(atomicInteger.intValue() + 1) < 200){
            new Thread(()->{
                LazyTypeSingleSafe instance = LazyTypeSingleSafe.getInstance();
                lazyTypeSingleSafeHashSet.add(instance);
            }).start();
        }

        for(LazyTypeSingleSafe lazyTypeSingleNoSafe: lazyTypeSingleSafeHashSet){
            System.out.println(lazyTypeSingleNoSafe);
        }
        //single.LazyTypeSingleNoSafe@6e5802d8
    }

    public static void threadEnvTest4() throws InterruptedException {
        Set<LazyTypeSingleSafeDoubleCheck> lazyTypeSingleSafeDoubleChecks = new HashSet<>();

        AtomicInteger atomicInteger = new AtomicInteger(0);

        while(atomicInteger.getAndSet(atomicInteger.intValue() + 1) < 200){
            new Thread(()->{
                LazyTypeSingleSafeDoubleCheck instance = LazyTypeSingleSafeDoubleCheck.getInstance();
                lazyTypeSingleSafeDoubleChecks.add(instance);
            }).start();
        }

        for(LazyTypeSingleSafeDoubleCheck lazyTypeSingleNoSafe: lazyTypeSingleSafeDoubleChecks){
            System.out.println(lazyTypeSingleNoSafe);
        }
        //single.LazyTypeSingleNoSafe@6e5802d8
        //single.LazyTypeSingleNoSafe@6706a70b
        //single.LazyTypeSingleNoSafe@51a22f1d
    }
    public static void main(String[] args) throws Exception {
        //testAbsoluteSingleSafe();
        //testLazyTypeSingleSafeInnerClass();
        //threadEnvTest();
        //threadEnvTest2();
        //threadEnvTest3();
        threadEnvTest4();
    }
}