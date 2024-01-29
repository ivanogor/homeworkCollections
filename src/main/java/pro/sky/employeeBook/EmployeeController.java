package pro.sky.employeeBook;

import exceptions.EmployeeAlreadyAddedException;
import exceptions.EmployeeNotFoundException;
import exceptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/add")
    public Employee addEmployee(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            return employeeService.addEmployee(employee);
        }
        catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException e) {
            throw e;
        }
    }

    @RequestMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            return employeeService.removeEmployee(employee);
        }
        catch (EmployeeNotFoundException e) {
            throw e;
        }
    }

    @RequestMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        try {
            return employeeService.findEmployee(employee);
        }
        catch (EmployeeNotFoundException e) {
            throw e;
        }
    }

    @RequestMapping("/display")
    public List<Employee> displayEmployees() {
        return employeeService.displayEmployees();
    }
}
