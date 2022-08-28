package com.example.naver.spring.boot.api.department.service;

import com.example.naver.spring.boot.api.department.controller.dto.response.DepartmentResponse;
import com.example.naver.spring.boot.api.department.repository.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();
    DepartmentResponse findDepartmentById(int id);
    DepartmentResponse findDepartmentWithBatis(int id);
    Department createDepartment(Department department);
    void updateDepartment(int id, Department updateModel);
    void deleteDepartment(int id);
}
