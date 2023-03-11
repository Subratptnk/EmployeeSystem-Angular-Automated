package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Department;
import entity.Employee;
import repository.DepartmentRepository;
import repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;
    
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
    
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setDepartment(employee.getDepartment());
            return employeeRepository.save(existingEmployee);
        } else {
            return null;
        }
    }
    
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }
    
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
    
    public Department updateDepartment(Department department) {
        Department existingDepartment = departmentRepository.findById(department.getId()).orElse(null);
        if (existingDepartment != null) {
            existingDepartment.setName(department.getName());
            existingDepartment.setEmployees(department.getEmployees());
            return departmentRepository.save(existingDepartment);
        } else {
            return null;
        }
    }
    
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}

