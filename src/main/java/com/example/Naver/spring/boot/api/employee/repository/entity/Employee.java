package com.example.naver.spring.boot.api.employee.repository.entity;

import com.example.naver.spring.boot.api.department.repository.entity.Department;
import com.example.naver.spring.boot.api.employee.model.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long employeeId;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "departmentId", nullable = false)
    private Department department;
}
