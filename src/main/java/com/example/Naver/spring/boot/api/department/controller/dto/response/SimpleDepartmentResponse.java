package com.example.naver.spring.boot.api.department.controller.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleDepartmentResponse {
    private int departmentId;
    private String name;
    private String description;
}
