package com.example.naver.spring.boot.api.employee.service;

import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public EmployeeDto getEmployeeDto(EmployeeDto dto) {
        return dto;
    }

}
