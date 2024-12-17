package tech.reliab.course.solntsevns.service;

import tech.reliab.course.solntsevns.entity.Employee;
import tech.reliab.course.solntsevns.model.EmployeeRequest;

import java.time.LocalDate;
import java.util.List;


public interface EmployeeService {
    Employee createEmployee(EmployeeRequest employeeRequest);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

    List<Employee> getAllEmployees();

}
