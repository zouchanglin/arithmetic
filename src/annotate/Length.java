package annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Length{
    // 允许的字符串长度最小值
    int min();

    // 允许的字符串长度最大值
    int max();

    // 自定义错误提示
    String errorMsg();
}