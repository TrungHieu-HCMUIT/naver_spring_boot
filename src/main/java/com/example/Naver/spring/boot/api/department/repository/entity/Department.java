package com.example.naver.spring.boot.api.department.repository.entity;

import com.example.naver.spring.boot.api.employee.repository.entity.Employee;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer departmentId;

    private String name;

    private String description;

    @OneToMany(mappedBy = "department")
    @Cascade(value = {org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<Employee> employees = new ArrayList<>();
}
