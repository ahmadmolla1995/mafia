package Exercise;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class EmployeeExample {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("ahmad", "molla", "single", 1000000));
        employees.add(new Employee("reza", "kiani", "single", 2000000));
        employees.add(new Employee("majid", "saedi", "single", 3000000));
        employees.add(new Employee("ali", "saeedi", "single", 1200000));
        
        employees.stream()
                .filter(e -> !e.isMarried())
                .filter(e -> e.getSalary() < 2000000)
                .sorted((a, b) -> (int) (a.getSalary() - b.getSalary()))
                .limit(10)
                .forEach(e -> System.out.println());
    }
}
