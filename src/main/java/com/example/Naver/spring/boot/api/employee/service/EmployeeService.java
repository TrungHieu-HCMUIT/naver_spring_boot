package com.example.naver.spring.boot.api.employee.service;

import com.example.naver.spring.boot.api.department.repository.DepartmentRepository;
import com.example.naver.spring.boot.api.department.repository.entity.Department;
import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeCreate;
import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeUpdate;
import com.example.naver.spring.boot.api.employee.controller.dto.response.EmployeeResponse;
import com.example.naver.spring.boot.api.employee.controller.dto.response.SimpleEmployeeResponse;
import com.example.naver.spring.boot.api.employee.model.Gender;
import com.example.naver.spring.boot.api.employee.repository.EmployeeMyBatisRepository;
import com.example.naver.spring.boot.api.employee.repository.EmployeeRepository;
import com.example.naver.spring.boot.api.employee.repository.entity.Employee;
import com.example.naver.spring.boot.common.Const;
import com.example.naver.spring.boot.common.error_handling.custom_exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMyBatisRepository employeeMyBatisRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public List<SimpleEmployeeResponse> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        List<SimpleEmployeeResponse> employeeResponses = employees.stream()
                .map(employee -> modelMapper.map(employee, SimpleEmployeeResponse.class))
                .collect(Collectors.toList());
        return employeeResponses;
    }

    public EmployeeResponse findEmployee(long id) {
//        var employee = employeeRepository.findById(id);
//        if (employee.isEmpty()) {
//            throw new DataNotFoundException(Const.EntityName.EMPLOYEE);
//        }
//        return employee.get();

        Employee employee = employeeMyBatisRepository.findById(id);
        if (employee == null) {
            throw new DataNotFoundException(Const.EntityName.EMPLOYEE);
        }

        return modelMapper.map(employee, EmployeeResponse.class);
    }

    public Employee createEmployee(EmployeeCreate employeeCreateDto) {
        var department = departmentRepository.findById(employeeCreateDto.getDepartmentId());
        if (department.isEmpty()) {
            throw new DataNotFoundException(Const.EntityName.DEPARTMENT);
        }

        Employee employee = modelMapper.map(employeeCreateDto, Employee.class);
        employee.setDepartment(department.get());

        return employeeRepository.save(employee);
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

        Integer departmentId = employeeUpdate.getDepartmentId();
        if (departmentId != null) {
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
