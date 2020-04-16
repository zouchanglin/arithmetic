package newjdk8.stream;

import newjdk8.lambda.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo3 {
    private static List<Employee> employeeList = Arrays.asList(
            new Employee(18, 5500, "Tom"),
            new Employee(28, 4500, "Jone"),
            new Employee(20, 3500, "Jack"),
            new Employee(25, 3500, "Tim"),
            new Employee(25, 3500, "Tim")
    );

    public static void main(String[] args) {
        // 收集员工的姓名到List中
        List<String> nameList = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        nameList.forEach(System.out::println);

        System.out.println("---------------------");

        // 收集员工的姓名到Set中
        Set<String> nameSet = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        nameSet.forEach(System.out::println);

        // 收集员工的姓名到其他结构中
        LinkedHashSet<String> linkedHashSet = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        linkedHashSet.forEach(System.out::println);

        // 收集员工的工资平均值
        Double averageSalary = employeeList.stream()
                .collect(Collectors.averagingInt(Employee::getSalary));
        System.out.println(averageSalary);

        // 收集员工工资总和
        Long summarySalary = employeeList.stream()
                .collect(Collectors.summingLong(Employee::getSalary));
        System.out.println(summarySalary);
    }

    public static void main1(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer sum = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        System.out.println("------------------------");

        Optional<Integer> salarySum = employeeList.stream()
                .map(Employee::getSalary)
                .reduce(Integer::sum);
        System.out.println(salarySum.get());
    }
}
