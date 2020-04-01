package thread_study.synchronize;

public class StringBufferWithoutSynchronized {
    public void add(String str1, String str2){
        //StringBuffer是线程安全,由于sb只会在append方法中使用,不可能被其他线程引用
        //因此sb属于不可能共享的资源, JVM会自动消除内部的锁
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str1).append(str2);
    }

    public static String copyString(String target){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            stringBuffer.append(target);
        }
        return stringBuffer.toString();
    }
}
