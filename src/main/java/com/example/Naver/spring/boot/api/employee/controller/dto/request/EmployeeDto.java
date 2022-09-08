package com.example.naver.spring.boot.api.employee.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class EmployeeDto {
    @NotNull(message = "Employee's ID cannot be null")
    @PositiveOrZero(message = "Invalid Employee's ID")
    private Integer employeeId;

    @NotBlank(message = "Employee's name cannot be blank")
    @Size(min = 10, max = 50, message = "Employee's name must be more than 10 characters and less than 50 characters")
    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

    @Pattern(regexp = "(MALE|FEMALE|OTHER)", message = "Invalid gender")
    private String gender;

    @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email")
    private String email;
}
