package com.example.naver.spring.boot.api.employee.controller;

import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeCreate;
import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeUpdate;
import com.example.naver.spring.boot.api.employee.controller.dto.response.EmployeeResponse;
import com.example.naver.spring.boot.api.employee.repository.entity.Employee;
import com.example.naver.spring.boot.api.employee.service.EmployeeService;
import com.example.naver.spring.boot.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController extends BaseController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @GetMapping("/employees")
    public ResponseEntity<Object> getEmployees() {
        return successResponse(employeeService.getEmployees());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable long id) {
        return successResponse(employeeService.findEmployeeById(id));
    }

    @GetMapping("/v2/employee/{id}")
    public ResponseEntity<Object> getEmployeeByIdV2(@PathVariable long id) {
        return successResponse(employeeService.findEmployeeWithBatis(id));
    }

    @PostMapping("/employee")
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeCreate employeeCreateDto) {
        Employee employee = employeeService.createEmployee(employeeCreateDto);
        EmployeeResponse employeeDto = modelMapper.map(employee, EmployeeResponse.class);
        return successResponse(employeeDto);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<Object> updateEmployee(@PathVariable int id, @RequestBody EmployeeUpdate employeeUpdate) {
        employeeService.updateEmployee(id, employeeUpdate);
        return successResponse("true");
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployee(id);
        return successResponse("true");
    }
}
