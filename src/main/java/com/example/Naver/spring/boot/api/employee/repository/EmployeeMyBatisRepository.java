package com.example.naver.spring.boot.api.employee.repository;

import com.example.naver.spring.boot.api.department.repository.entity.Department;
import com.example.naver.spring.boot.api.employee.repository.entity.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMyBatisRepository {

    @Select("SELECT * FROM EMPLOYEE WHERE id = #{id}")
    @Results(value = {
            @Result(property = "employeeId", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "department", column = "department_id", one = @One(select = "findDepartmentById"))
    })
    Employee findById(long id);

    @Select("SELECT * FROM DEPARTMENT WHERE id = #{id}")
    @Results(value = {
            @Result(property = "departmentId", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
    })
    public Department findDepartmentById(int id);
}
