package pro.sky.employeeBook;

import exceptions.EmployeeAlreadyAddedException;
import exceptions.EmployeeNotFoundException;
import exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final int MAX_NUMBER_OF_EMPLOYEE = 5;
    private List<Employee> listOfEmployee = new ArrayList<>();

    public Employee addEmployee(Employee employee) {
        if (listOfEmployee.size() < MAX_NUMBER_OF_EMPLOYEE) {
            if (!listOfEmployee.contains(employee)) {
                listOfEmployee.add(employee);
                return employee;
            }
            else {
                throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
            }
        }
        else {
            throw new EmployeeStorageIsFullException("ArrayIsFull");
        }
    }

    public Employee findEmployee(Employee employee) {
        if (listOfEmployee.contains(employee)) {
            return employee;
        }
        else {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
    }

    public Employee removeEmployee(Employee employee) {
        if (listOfEmployee.contains(employee)) {
            listOfEmployee.remove(employee);
            return employee;
        }
        else {
            throw new EmployeeNotFoundException("EmployeeNotFound");
        }
    }

    public List<Employee> displayEmployees() {
        return listOfEmployee;
    }
}
