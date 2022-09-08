package com.example.naver.spring.boot.api.department.controller;

import com.example.naver.spring.boot.api.department.controller.dto.request.DepartmentDto;
import com.example.naver.spring.boot.api.department.service.DepartmentService;
import com.example.naver.spring.boot.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/likelion")
@RequiredArgsConstructor
public class DepartmentController extends BaseController {

    private final DepartmentService departmentService;

    @GetMapping("/department")
    public ResponseEntity<Object> getDepartment(@RequestBody @Valid DepartmentDto departmentDto) {
        return successResponse(departmentService.getDepartment(departmentDto));
    }
}
