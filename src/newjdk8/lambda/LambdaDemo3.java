package newjdk8.lambda;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaDemo3 {

    public static void main(String[] args) {
        //Function<Integer, String[]> function = (x) -> new String[x];
        Function<Integer, String[]> function = String[]::new;
        String[] strings = function.apply(10);
        System.out.println(strings.length);
    }

    public static void main2(String[] args) {
        // 自动匹配无参构造器
        Supplier<Employee> supplier = Employee::new;

        Function<Integer, Employee> function0 = (x) -> new Employee(x);

        // 自动匹配Age带参构造器
        Function<Integer, Employee> function1 = Employee::new;
        Employee employee0 = function1.apply(18);
        System.out.println(employee0);

        BiFunction<Integer, Integer, Employee> biFunction = Employee::new;
        Employee employee1 = biFunction.apply(18, 5500);
        System.out.println(employee1);
    }
}
