package single_mode;

//懒汉式单例 + 双重锁检查(多线程下安全并且效率优化)
public class LazyTypeSingleSafeDoubleCheck {
    private static LazyTypeSingleSafeDoubleCheck lazyTypeSingleSafeDoubleCheck;
    public static LazyTypeSingleSafeDoubleCheck getInstance(){
        if(lazyTypeSingleSafeDoubleCheck == null){
            synchronized (LazyTypeSingleSafeDoubleCheck.class){
                if(lazyTypeSingleSafeDoubleCheck == null){
                    lazyTypeSingleSafeDoubleCheck = new LazyTypeSingleSafeDoubleCheck();
                }
            }
        }
        return lazyTypeSingleSafeDoubleCheck;
    }
    private LazyTypeSingleSafeDoubleCheck(){}
}