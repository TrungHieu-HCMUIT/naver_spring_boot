package com.example.naver.spring.boot.api.employee.service;

import com.example.naver.spring.boot.api.department.repository.DepartmentRepository;
import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeCreateDto;
import com.example.naver.spring.boot.api.employee.repository.EmployeeRepository;
import com.example.naver.spring.boot.api.employee.repository.entity.Employee;
import com.example.naver.spring.boot.common.Const;
import com.example.naver.spring.boot.common.error_handling.custom_exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper mapper;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployee(long id) {
        var employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new DataNotFoundException(Const.EntityName.EMPLOYEE);
        }
        return employee.get();
    }

    public Employee createEmployee(EmployeeCreateDto employeeCreateDto) {
        var department = departmentRepository.findById(employeeCreateDto.getDepartmentId());
        if (department.isEmpty()) {
            throw new DataNotFoundException(Const.EntityName.DEPARTMENT);
        }

        Employee employee = mapper.map(employeeCreateDto, Employee.class);
        employee.setDepartment(department.get());

        var result = employeeRepository.save(employee);

        return employee;
    }

    public void deleteEmployee(long id) {
        boolean isExist = employeeRepository.existsById(id);
        if (!isExist) {
            throw new DataNotFoundException(Const.EntityName.EMPLOYEE);
        }
        employeeRepository.deleteById(id);
    }
}
