package com.example.okestromybatis.mapper;

import com.example.okestromybatis.domain.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {


    @Insert("INSERT INTO employee(company_id,employee_name, employee_address) VALUES(#{employee.companyId},#{employee.name}, #{employee.address})")
    @Options(useGeneratedKeys = true,keyProperty = "id") // 반환 결과에 따른 ID 생성
    int insert(@Param("employee") Employee employee);

    @Select("SELECT * FROM employee")
    @Results(id="EmployeeMap",value={
            // DTO 의 속성과 매핑
            @Result(property="name", column="employee_name"),
            @Result(property = "address" ,column = "employee_address")
    })

    List<Employee> getAll();

    @Select("SELECT * FROM employee WHERE id=#{id}")
    @ResultMap("EmployeeMap") // Results 재사용
    Employee getById(@Param("id")int id);

    @Select("SELECT * FROM employee WHERE company_id=#{companyId}")
    @ResultMap("EmployeeMap")
    List<Employee> getByCompanyId(@Param("companyId") int companyId);

}
