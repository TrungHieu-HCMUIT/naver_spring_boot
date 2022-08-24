package com.example.naver.spring.boot.api.employee.controller.dto.response;

import com.example.naver.spring.boot.api.employee.model.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Getter
@Setter
public class SimpleEmployeeResponse {

    private long employeeId;

    private String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
