package newjdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaDemo {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(18, 5500, "Tom"),
                new Employee(28, 4500, "Jone"),
                new Employee(20, 3500, "Jack"),
                new Employee(25, 8500, "Tim")
        );

        // 薪水大于1000的有4个，但是我只需要前面两个
        employeeList.stream()
                .filter((e) -> e.getSalary() > 1000)
                .limit(2)
                .forEach(System.out::println);

        // 只把名字提取出来
        List<String> nameList = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        nameList.forEach(System.out::println);
    }
}