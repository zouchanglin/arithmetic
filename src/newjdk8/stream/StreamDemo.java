package newjdk8.stream;

import newjdk8.lambda.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        // 1、获取流的第一种方式: stream()获取数组流
        List<String> list = new ArrayList<>();
        Stream<String> stringStream0 = list.stream();

        // 2、获取流的第二种方式：Arrays的静态方法stream()获取数组流
        Employee[] employeeArray = new Employee[10];
        Stream<Employee> employeeStream = Arrays.stream(employeeArray);

        // 3、获取流的第三种方式：通过Stream类中的静态方法of()
        Stream<String> stringStream1 = Stream.of("AAA", "BBB", "CCC");

        // 4、获取流的第四种方式：创建无限流
        // ①迭代的方式
        Stream<Integer> integerStream = Stream.iterate(0, (x) -> x + 2);
        integerStream.limit(10).forEach(System.out::println);

        // ②生成的方式
        Stream<Double> doubleStream = Stream.generate(() -> Math.random());
        doubleStream.limit(5).forEach(System.out::println);
    }
}
