package tech.reliab.course.solntsevns.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.solntsevns.entity.Employee;
import tech.reliab.course.solntsevns.model.EmployeeRequest;
import tech.reliab.course.solntsevns.repository.EmployeeRepository;
import tech.reliab.course.solntsevns.service.BankOfficeService;
import tech.reliab.course.solntsevns.service.BankService;
import tech.reliab.course.solntsevns.service.EmployeeService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BankService bankService;
    private final BankOfficeService bankOfficeService;

    public Employee createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee(employeeRequest.getFullName(), employeeRequest.getBirthDate(),
                employeeRequest.getPosition(), bankOfficeService.getOffice(employeeRequest.getBankOfficeId()),
                employeeRequest.getSalary(), employeeRequest.isCanIssueLoans());
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee was not found"));
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
