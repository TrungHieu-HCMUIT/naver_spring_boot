package com.example.naver.spring.boot.api.department.controller.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentCreate {
    private String name;
    private String description;
}
