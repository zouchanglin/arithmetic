package newjdk8.stream;

import newjdk8.lambda.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamDemo2 {
    private static List<Employee> employeeList = Arrays.asList(
            new Employee(18, 5500, "Tom"),
            new Employee(28, 4500, "Jone"),
            new Employee(20, 3500, "Jack"),
            new Employee(25, 3500, "Tim"),
            new Employee(25, 3500, "Tim")
    );

    public static void main(String[] args) {
        // 判断是不是所有员工工资都是3500
        boolean match = employeeList.stream()
                .allMatch((e) -> e.getSalary() == 3500);
        System.out.println(match);

        // 判断是不是至少有一个员工姓名是Tim
        boolean timExist = employeeList.stream()
                .anyMatch((e) -> e.getName().equals("Tim"));
        System.out.println(timExist);

        // 判断是否存在员工年龄小于20
        boolean ageMatch = employeeList.stream()
                .noneMatch((e) -> e.getAge() < 20);
        System.out.println(ageMatch);

        // 根据员工工资排序，并得到第一个结果
        Optional<Employee> employee = employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .findFirst();
        System.out.println(employee.get());

        // 获取员工工资最高的员工信息
        Optional<Employee> maxEmployee = employeeList.stream()
                .max(Comparator.comparingInt(Employee::getSalary));
        System.out.println(maxEmployee.get());

        // 获取员工最低工资
        Optional<Integer> minSalary = employeeList.stream()
                .map(Employee::getSalary)
                .min(Integer::compareTo);
        System.out.println(minSalary);
    }

    public static void main4(String[] args) {
        employeeList.stream()
                .sorted((x, y) -> {
                    //年龄一样按照姓名排序
                    if(x.getAge() == y.getAge()){
                        return x.getName().compareTo(y.getName());
                    }else{
                        return x.getAge() - y.getAge();
                    }
                })
                .forEach(System.out::println);
    }

    public static void main3(String[] args) {
        List<String> stringList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        stringList.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
        System.out.println("-------------------");
        employeeList.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    public static void main2(String[] args) {
        employeeList.stream()
                .filter((x)-> x.getAge() > 20)
                .forEach(System.out::println);
        System.out.println("----------------");
        employeeList.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
