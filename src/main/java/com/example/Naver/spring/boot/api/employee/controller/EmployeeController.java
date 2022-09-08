package com.example.naver.spring.boot.api.employee.controller;

import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeDto;
import com.example.naver.spring.boot.api.employee.service.EmployeeService;
import com.example.naver.spring.boot.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/likelion")
@RequiredArgsConstructor
public class EmployeeController extends BaseController {

    private final EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<Object> getEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        return successResponse(employeeService.getEmployeeDto(employeeDto));
    }
}
