package imooc.sort;

public class Student implements Comparable<Student>{
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private String name;
    private Integer age;

    @Override
    public int compareTo(Student student) {
        //return this.name.compareTo(student.name);
        return this.age - student.age;
    }
}