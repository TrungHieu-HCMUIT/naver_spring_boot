package com.example.naver.spring.boot.api.department.service;

import com.example.naver.spring.boot.api.department.controller.dto.response.DepartmentResponse;
import com.example.naver.spring.boot.api.department.repository.DepartmentMyBatisRepository;
import com.example.naver.spring.boot.api.department.repository.DepartmentRepository;
import com.example.naver.spring.boot.api.department.repository.entity.Department;
import com.example.naver.spring.boot.common.Const;
import com.example.naver.spring.boot.common.error_handling.custom_exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Resource
    private final DepartmentMyBatisRepository departmentMyBatisRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentResponse findDepartmentById(int id) {
        var department = departmentRepository.findById(id);
        if (department.isEmpty()) {
            throw new DataNotFoundException(Const.EntityName.DEPARTMENT);
        }

        return modelMapper.map(department.get(), DepartmentResponse.class);
    }

    @Override
    public DepartmentResponse findDepartmentWithBatis(int id) {
        Department department = departmentMyBatisRepository.findById(id);
        if (department == null) {
            throw new DataNotFoundException(Const.EntityName.DEPARTMENT);
        }

        return modelMapper.map(department, DepartmentResponse.class);
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(int id, Department updateModel) {
        var department = departmentRepository.findById(id);
        if (department.isEmpty()) {
            throw new DataNotFoundException(Const.EntityName.DEPARTMENT);
        }

        Department checkedDepartment = department.get();

        modelMapper.map(updateModel, checkedDepartment);
        departmentRepository.save(checkedDepartment);
    }

    @Override
    public void deleteDepartment(int id) {
        boolean isExist = departmentRepository.existsById(id);
        if (!isExist) {
            throw new DataNotFoundException(Const.EntityName.DEPARTMENT);
        }
        departmentRepository.deleteById(id);
    }
}
