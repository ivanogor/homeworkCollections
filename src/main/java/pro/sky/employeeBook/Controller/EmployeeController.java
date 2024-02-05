package pro.sky.employeeBook.Controller;

import pro.sky.employeeBook.model.Employee;
import pro.sky.employeeBook.Service.EmployeeService;
import pro.sky.employeeBook.exceptions.EmployeeAlreadyAddedException;
import pro.sky.employeeBook.exceptions.EmployeeNotFoundException;
import pro.sky.employeeBook.exceptions.EmployeeStorageIsFullException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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
        try {
            return employeeService.addEmployee(firstName, lastName);
        }
        catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException e) {
            throw e;
        }
    }

    @RequestMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        try {
            return employeeService.removeEmployee(firstName, lastName);
        }
        catch (EmployeeNotFoundException e) {
            throw e;
        }
    }

    @RequestMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        try {
            return employeeService.findEmployee(firstName, lastName);
        }
        catch (EmployeeNotFoundException e) {
            throw e;
        }
    }

    @RequestMapping("/display")
    public Employee[] displayEmployees() {
        return employeeService.displayEmployees();
    }
}
