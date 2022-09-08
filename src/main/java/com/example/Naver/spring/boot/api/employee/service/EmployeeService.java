package com.example.naver.spring.boot.api.employee.service;


import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeDto;

public interface EmployeeService {
    EmployeeDto getEmployeeDto(EmployeeDto dto);
}
