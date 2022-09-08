package com.example.naver.spring.boot.api.department.service;


import com.example.naver.spring.boot.api.department.controller.dto.request.DepartmentDto;

public interface DepartmentService {
    DepartmentDto getDepartment(DepartmentDto dto);
}
