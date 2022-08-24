package com.example.naver.spring.boot.api.employee.repository;

import com.example.naver.spring.boot.api.employee.repository.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
