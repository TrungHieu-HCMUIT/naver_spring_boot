package com.example.naver.spring.boot.api.employee.service;

import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeCreate;
import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeUpdate;
import com.example.naver.spring.boot.api.employee.controller.dto.response.EmployeeResponse;
import com.example.naver.spring.boot.api.employee.controller.dto.response.SimpleEmployeeResponse;
import com.example.naver.spring.boot.api.employee.repository.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<SimpleEmployeeResponse> getEmployees();
    EmployeeResponse findEmployeeWithBatis(long id);
    EmployeeResponse findEmployeeById(long id);
    Employee createEmployee(EmployeeCreate employeeCreateDto);
    void updateEmployee(long id, EmployeeUpdate employeeUpdate);
    void deleteEmployee(long id);
}
