package newjdk8.dateapi.annotation;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.*;


@Repeatable(MyAnnotations.class) // 指定容器
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value() default "Tim";
}
