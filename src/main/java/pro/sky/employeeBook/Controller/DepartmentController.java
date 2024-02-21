package pro.sky.employeeBook.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.employeeBook.Service.DepartmentService;
import pro.sky.employeeBook.model.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping("/max-salary")
    public Employee findEmployeeWithBiggestSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.findEmployeeWithBiggestSalary(departmentId);
    }
    @RequestMapping("/min-salary")
    public Employee findEmployeeWithLowestSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.findEmployeeWithLowestSalary(departmentId);
    }

    @RequestMapping("/sum-salary")
    public double sumSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.sumSalary(departmentId);
    }

    @RequestMapping("/average-salary")
    public double averageSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.averageSalary(departmentId);
    }

    @RequestMapping("/employee-count")
    public int countEmployeeInDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentService.countEmployeeInDepartment(departmentId);
    }

    @RequestMapping("/employee-with-higher")
    public List<Employee>  findEmployeeWithHigherSalary(@RequestParam("salary") int salary) {
        return departmentService.findEmployeeWithHigherSalary(salary);
    }

    @RequestMapping("/employee-with-less")
    public List<Employee> findEmployeeWithLessSalary(@RequestParam("salary") int salary) {
        return departmentService.findEmployeeWithLessSalary(salary);
    }

    @RequestMapping("/all")
    public List<Employee> displayAllEmployeesByDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentService.displayAllEmployeesByDepartment(departmentId);
    }

    @RequestMapping("/all-departments")
    public Map<Integer, List<Employee>> displayAllEmployeesByDepartment() {
        return departmentService.displayAllEmployeesByDepartment();
    }
}
