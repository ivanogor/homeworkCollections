package pro.sky.employeeBook.Service;

import org.springframework.stereotype.Service;
import pro.sky.employeeBook.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    public Employee findEmployeeWithBiggestSalary(int departmentId) {
        return employeeService.displayEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(RuntimeException::new);
    }

    public Employee findEmployeeWithLowestSalary(int departmentId) {
        return employeeService.displayEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(RuntimeException::new);
    }

    public double sumSalary(int departmentId) {
        return employeeService.displayEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public double averageSalary(int departmentId) {
        return employeeService.displayEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .mapToDouble(Employee::getSalary)
                .average()
                .orElseThrow(RuntimeException::new);
    }

    public int countEmployeeInDepartment(int departmentId) {
        return (int)employeeService.displayEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .count();
    }

    public List<Employee> findEmployeeWithHigherSalary(int salary) {
        return employeeService.displayEmployees().stream()
                .filter(employee -> employee.getSalary() > salary)
                .collect(Collectors.toList());
    }

    public List<Employee> findEmployeeWithLessSalary(int salary) {
        return employeeService.displayEmployees().stream()
                .filter(employee -> employee.getSalary() < salary)
                .collect(Collectors.toList());
    }

    public List<Employee> displayAllEmployeesByDepartment(int departmentId) {
        return employeeService.displayEmployees().stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> displayAllEmployeesByDepartment() {
        Map<Integer, List<Employee>> result = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            int finalI = i;
            result.put(i, employeeService.displayEmployees().stream()
                    .filter(employee -> employee.getDepartment() == finalI)
                    .collect(Collectors.toList()));
        }
        return result;
    }
}
