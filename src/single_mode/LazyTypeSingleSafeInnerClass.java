package single_mode;

//懒汉式单例 静态内部类实现（推荐）
public class LazyTypeSingleSafeInnerClass {
    private static class LazyTypeSingleSafeInnerClassHolder{
        private static LazyTypeSingleSafeInnerClass singleSafe = new LazyTypeSingleSafeInnerClass();
    }
    public static LazyTypeSingleSafeInnerClass getInstance(){
        return LazyTypeSingleSafeInnerClassHolder.singleSafe;
    }
    private LazyTypeSingleSafeInnerClass(){}
}