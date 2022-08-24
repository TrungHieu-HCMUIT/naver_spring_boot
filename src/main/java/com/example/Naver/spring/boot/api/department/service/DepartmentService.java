package com.example.naver.spring.boot.api.department.service;

import com.example.naver.spring.boot.api.department.repository.DepartmentRepository;
import com.example.naver.spring.boot.api.department.repository.entity.Department;
import com.example.naver.spring.boot.common.Const;
import com.example.naver.spring.boot.common.error_handling.custom_exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department findDepartment(int id) {
        var department = departmentRepository.findById(id);
        if (department.isEmpty()) {
            throw new DataNotFoundException(Const.EntityName.DEPARTMENT);
        }
        return department.get();
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(int id) {
        boolean isExist = departmentRepository.existsById(id);
        if (!isExist) {
            throw new DataNotFoundException(Const.EntityName.DEPARTMENT);
        }
        departmentRepository.deleteById(id);
    }
}
