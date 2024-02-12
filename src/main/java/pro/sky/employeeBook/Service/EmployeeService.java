package pro.sky.employeeBook.Service;

import pro.sky.employeeBook.model.Employee;
import pro.sky.employeeBook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeeBook.exceptions.EmployeeNotFoundException;
import pro.sky.employeeBook.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final int MAX_NUMBER_OF_EMPLOYEE = 5;
    private Map<String, Employee> employeeBook = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        if (employeeBook.size() < MAX_NUMBER_OF_EMPLOYEE) {
            String name = firstName + lastName;
            if (!employeeBook.containsKey(name)) {
                Employee employee = new Employee(firstName, lastName, department, salary);
                employeeBook.put(name, employee);
                return employee;
            } else {
                throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
            }
        } else {
            throw new EmployeeStorageIsFullException("ArrayIsFull");
        }
    }

    public Employee findEmployee(String firstName, String lastName) {
        String name = firstName + lastName;
        if (employeeBook.containsKey(name)) {
            return employeeBook.get(name);
        } else {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {
        String name = firstName + lastName;
        Employee employee = employeeBook.get(name);
        if (employeeBook.remove(name, employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
    }

    public Collection<Employee> displayEmployees() {
        return Collections.unmodifiableCollection(employeeBook.values());
    }
}
