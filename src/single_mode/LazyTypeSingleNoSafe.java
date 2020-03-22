package single_mode;

//懒汉式单例(多线程下不安全)
public class LazyTypeSingleNoSafe {
    private static LazyTypeSingleNoSafe lazyTypeSingleNoSafe;

    public static LazyTypeSingleNoSafe getInstance(){
        if(lazyTypeSingleNoSafe == null){
            lazyTypeSingleNoSafe = new LazyTypeSingleNoSafe();
        }
        return lazyTypeSingleNoSafe;
    }

    private LazyTypeSingleNoSafe(){}
}
