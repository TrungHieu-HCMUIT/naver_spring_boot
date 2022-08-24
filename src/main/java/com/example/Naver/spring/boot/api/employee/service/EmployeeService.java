package com.example.naver.spring.boot.api.employee.service;

import com.example.naver.spring.boot.api.department.repository.DepartmentRepository;
import com.example.naver.spring.boot.api.department.repository.entity.Department;
import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeCreate;
import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeUpdate;
import com.example.naver.spring.boot.api.employee.model.Gender;
import com.example.naver.spring.boot.api.employee.repository.EmployeeRepository;
import com.example.naver.spring.boot.api.employee.repository.entity.Employee;
import com.example.naver.spring.boot.common.Const;
import com.example.naver.spring.boot.common.error_handling.custom_exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public Employee createEmployee(EmployeeCreate employeeCreateDto) {
        var department = departmentRepository.findById(employeeCreateDto.getDepartmentId());
        if (department.isEmpty()) {
            throw new DataNotFoundException(Const.EntityName.DEPARTMENT);
        }

        Employee employee = mapper.map(employeeCreateDto, Employee.class);
        employee.setDepartment(department.get());

        var result = employeeRepository.save(employee);

        return employee;
    }

    public void updateEmployee(long id, EmployeeUpdate employeeUpdate) {
        var employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new DataNotFoundException(Const.EntityName.EMPLOYEE);
        }

        String nameToUpdate = employeeUpdate.getName();
        Date birthdayToUpdate = employeeUpdate.getBirthday();
        Gender genderToUpdate = employeeUpdate.getGender();
        Department departmentToUpdate = null;

        int departmentId = employeeUpdate.getDepartmentId();
        if (departmentId != 0) {
            var department  = departmentRepository.findById(departmentId);
            if (department.isEmpty()) {
                throw new DataNotFoundException(Const.EntityName.DEPARTMENT);
            }
            departmentToUpdate = department.get();
        }

        Employee checkedEmployee = employee.get();
        if (nameToUpdate != null) {
            checkedEmployee.setName(nameToUpdate);
        }
        if (birthdayToUpdate != null) {
            checkedEmployee.setBirthday(birthdayToUpdate);
        }
        if (genderToUpdate != null) {
            checkedEmployee.setGender(genderToUpdate);
        }
        if (departmentToUpdate != null) {
            checkedEmployee.setDepartment(departmentToUpdate);
        }
        employeeRepository.save(checkedEmployee);
    }

    public void deleteEmployee(long id) {
        boolean isExist = employeeRepository.existsById(id);
        if (!isExist) {
            throw new DataNotFoundException(Const.EntityName.EMPLOYEE);
        }
        employeeRepository.deleteById(id);
    }
}
