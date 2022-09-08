package com.example.naver.spring.boot.api.department.controller.dto.request;

import com.example.naver.spring.boot.api.employee.controller.dto.request.EmployeeDto;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Data
public class DepartmentDto {
    @NotNull(message = "Department's ID cannot be null")
    @PositiveOrZero(message = "Invalid department's ID")
    private Integer departmentId;

    @NotBlank(message = "Department's name cannot be blank")
    @Size(min = 10, max = 50, message = "Department's name must be more than 10 characters and less than 50 characters")
    private String name;

    @NotBlank(message = "Department's description cannot be blank")
    private String description;

    @Valid
    private List<EmployeeDto> employees;
}
