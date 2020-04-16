package newjdk8.lambda;

// 根据薪水定义的过滤器
public class EmployeeSalaryFilterPredict implements MyFilterPredict {
    @Override
    public boolean filter(Employee employee) {
        return employee.getSalary() > 5000;
    }
}
