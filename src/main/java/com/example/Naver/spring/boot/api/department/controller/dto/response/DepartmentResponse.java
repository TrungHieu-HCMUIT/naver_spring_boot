package com.example.naver.spring.boot.api.department.controller.dto.response;

import com.example.naver.spring.boot.api.employee.controller.dto.response.SimpleEmployeeResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DepartmentResponse {
    private int departmentId;
    private String name;
    private String description;
    private List<SimpleEmployeeResponse> employees;
}
