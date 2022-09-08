package com.example.naver.spring.boot.api.employee.service;

import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public EmployeeDto getEmployeeDto(EmployeeDto dto) {
        return dto;
    }

}
