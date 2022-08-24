package com.example.naver.spring.boot.api.department.repository;

import com.example.naver.spring.boot.api.department.repository.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
