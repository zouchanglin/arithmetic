package newjdk8.dateapi.annotation;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Method;

public class TestAnnotation {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<TestAnnotation> annotationClass = TestAnnotation.class;
        Method method = annotationClass.getMethod("show");
        MyAnnotation[] myAnnotations = method.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation: myAnnotations){
            System.out.println(myAnnotation.value());
        }
    }

    @MyAnnotation("Hello")
    @MyAnnotation("World")
    // 可以注解类型
    public void show(@MyAnnotation("abc") String str){

    }
}