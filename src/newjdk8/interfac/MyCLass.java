package newjdk8.interfac;

public class MyCLass implements MyFunc, MyFunc2 {
    @Override
    public String getName() {
        // 1、要么就指定用谁的
        return MyFunc.super.getName();
    }
}