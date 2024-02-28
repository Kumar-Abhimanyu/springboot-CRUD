package controller;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new Employee
    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    // Get all Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee EmployeeDetails) {
        Optional<Employee> Employee = employeeRepository.findById(id);
        if (Employee.isPresent()) {
            Employee existingEmployee = Employee.get();
            existingEmployee.setName(EmployeeDetails.getName());
            existingEmployee.setEmail(EmployeeDetails.getEmail());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    // Delete all Employees
    public void deleteAllEmployees() {
        employeeRepository.deleteAll();
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Other business logic related to Employees
}
