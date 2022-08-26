package com.example.naver.spring.boot.api.department.repository;

import com.example.naver.spring.boot.api.department.repository.entity.Department;
import com.example.naver.spring.boot.api.employee.repository.entity.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DepartmentMyBatisRepository{

    @Select("SELECT * FROM DEPARTMENT WHERE id = #{id}")
    @Results(value = {
            @Result(property = "departmentId", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "employees", column = "id", javaType = List.class, many = @Many(select = "getAllEmployeesOfDepartment"))
    })
    public Department findById(int id);

    @Select("SELECT * FROM EMPLOYEE WHERE department_id = #{departmentId}")
    @Results(value = {
            @Result(property = "employeeId", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "gender", column = "gender"),
    })
    public List<Employee> getAllEmployeesOfDepartment(int departmentId);
}
