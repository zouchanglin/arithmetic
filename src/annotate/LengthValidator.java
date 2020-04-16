package annotate;

import java.lang.reflect.Field;

public class LengthValidator {
    public static String validateField(Object object) throws IllegalAccessException {
        // 获取字段值
        // 对本文来说就是Person的id、name、age三个字段
        Field[] fields = object.getClass().getDeclaredFields();

        // 逐个字段校验，看看哪个字段标了注解
        for (Field field: fields){
            // if判断：检查字段上面有没有标注@Length注解
            if(field.isAnnotationPresent(Length.class)){
                // 通过反射获取到该字段上标注的@Length的注解的详细信息
                Length length = field.getAnnotation(Length.class);
                // 让我们在反射时看到私有变量
                field.setAccessible(true);
                // 获取实际字段的值
                int value = ((String)field.get(object)).length();
                // 将实际字段的值和注解的标记值进行对比
                if(value < length.min() || value > length.max()){
                    return length.errorMsg();
                }
            }
        }

        return null;
    }
}
