package com.example.naver.spring.boot.api.employee.controller;

import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeCreateDto;
import com.example.naver.spring.boot.api.employee.controller.dto.response.EmployeeResponse;
import com.example.naver.spring.boot.api.employee.repository.entity.Employee;
import com.example.naver.spring.boot.api.employee.service.EmployeeService;
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
public class EmployeeController extends BaseController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployees() {
        List<Employee> employees = employeeService.getEmployees();
        List<EmployeeResponse> employeesDto = employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());
        return successResponse(employeesDto);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable long id) {
        Employee employee = employeeService.findEmployee(id);
        EmployeeResponse employeeDto = modelMapper.map(employee, EmployeeResponse.class);
        return successResponse(employeeDto);
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeCreateDto employeeCreateDto) {
        Employee employee = employeeService.createEmployee(employeeCreateDto);
        EmployeeResponse employeeDto = modelMapper.map(employee, EmployeeResponse.class);
        return successResponse(employeeDto);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return successResponse("true");
    }
}