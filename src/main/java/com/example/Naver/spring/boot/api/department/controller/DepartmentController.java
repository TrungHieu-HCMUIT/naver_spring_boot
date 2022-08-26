package com.example.naver.spring.boot.api.department.controller;

import com.example.naver.spring.boot.api.department.controller.dto.request.DepartmentCreate;
import com.example.naver.spring.boot.api.department.controller.dto.request.DepartmentUpdate;
import com.example.naver.spring.boot.api.department.controller.dto.response.DepartmentResponse;
import com.example.naver.spring.boot.api.department.controller.dto.response.SimpleDepartmentResponse;
import com.example.naver.spring.boot.api.department.repository.entity.Department;
import com.example.naver.spring.boot.api.department.service.DepartmentService;
import com.example.naver.spring.boot.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DepartmentController extends BaseController {

    private final DepartmentService departmentService;
    private final ModelMapper modelMapper;

    @GetMapping("/departments")
    public ResponseEntity<Object> getDepartments() {
        List<Department> departments = departmentService.getDepartments();
        List<SimpleDepartmentResponse> departmentsDto = departments.stream()
                .map(department -> modelMapper.map(department, SimpleDepartmentResponse.class))
                .collect(Collectors.toList());

        return successResponse(departmentsDto);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Object> getDepartmentById(@PathVariable int id) {
        return successResponse(departmentService.findDepartment(id));
    }

    @PostMapping("/department")
    public ResponseEntity<Object> createDepartment(@RequestBody DepartmentCreate departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);
        return successResponse(departmentService.createDepartment(department));
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<Object> updateDepartment(@PathVariable int id, @RequestBody DepartmentUpdate departmentUpdate) {
        Department department = modelMapper.map(departmentUpdate, Department.class);
        departmentService.updateDepartment(id, department);
        return successResponse("true");
    }

    @DeleteMapping("/department/{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
        return successResponse("true");
    }
}
