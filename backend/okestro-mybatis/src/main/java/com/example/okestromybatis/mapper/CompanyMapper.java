package com.example.okestromybatis.mapper;

import com.example.okestromybatis.domain.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CompanyMapper {

    @Insert("INSERT INTO company(company_name, company_address) VALUES(#{company.name}, #{company.address})")
    @Options(useGeneratedKeys = true,keyProperty = "id") // 반환 결과에 따른 ID 생성
    int insert(@Param("company") Company company);

    @Select("SELECT * FROM company")
    @Results(id="CompanyMap",value={
            // DTO 의 속성과 매핑
            @Result(property="name", column="company_name"),
            @Result(property = "address" ,column = "company_address"),
            @Result(property = "employeeList",column = "id",many=@Many(select = "com.example.okestromybatis.mapper.EmployeeMapper.getByCompanyId"))

    })
    List<Company> getAll();

    @Select("SELECT * FROM company WHERE id=#{id}")
    @ResultMap("CompanyMap") // Results 재사용
    Company getById(@Param("id")int id);


}
