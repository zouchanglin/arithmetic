package newjdk8.lambda;

// 根据年龄定义的过滤器
public class EmployeeAgeFilterPredict implements MyFilterPredict {
    @Override
    public boolean filter(Employee employee) {
        return employee.getAge() > 20;
    }
}
