package single_mode;

//懒汉式单例 + 获取对象加锁(多线程下安全)
public class LazyTypeSingleSafe {
    private static LazyTypeSingleSafe lazyTypeSingleSafe;

    public static synchronized LazyTypeSingleSafe getInstance(){
        if(lazyTypeSingleSafe == null){
            lazyTypeSingleSafe = new LazyTypeSingleSafe();
        }
        return lazyTypeSingleSafe;
    }

    private LazyTypeSingleSafe(){}
}