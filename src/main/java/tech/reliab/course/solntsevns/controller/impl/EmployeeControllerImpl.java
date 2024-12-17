package tech.reliab.course.solntsevns.controller.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.solntsevns.controller.EmployeeController;
import tech.reliab.course.solntsevns.entity.Employee;
import tech.reliab.course.solntsevns.model.EmployeeRequest;
import tech.reliab.course.solntsevns.service.EmployeeService;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeService employeeService;
    @Override
    @PostMapping
    public ResponseEntity<Employee> createEmployee(EmployeeRequest employeeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeRequest));
    }
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(int id) {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }
    @Override
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}