package newjdk8.lambda;

import java.util.Objects;

public class Employee {
    // 年龄
    private int age;
    // 薪水
    private int salary;
    // 姓名
    private String name;

    public Employee() { }

    public Employee(int age, int salary, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    public Employee(int age) {
        this.age = age;
    }

    public Employee(Integer age, Integer salary) {
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                salary == employee.salary &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, salary, name);
    }
}
