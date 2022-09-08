package com.example.naver.spring.boot.api.department.service;

import com.example.naver.spring.boot.api.department.controller.dto.request.DepartmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public DepartmentDto getDepartment(DepartmentDto dto) {
        return dto;
    }
}
