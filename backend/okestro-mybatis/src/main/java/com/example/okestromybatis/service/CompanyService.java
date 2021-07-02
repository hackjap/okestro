package com.example.okestromybatis.service;

import com.example.okestromybatis.domain.Company;
import com.example.okestromybatis.mapper.CompanyMapper;
import com.example.okestromybatis.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Company> getAll(){
        List<Company> companyList = companyMapper.getAll();
        if(companyList != null && companyList.size()>0){
            for(Company company: companyList){
                company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));


            }
        }
        return companyList;
    }


    // 에러시, 데이터베이스의 입력된 데이터를 저장하지 않고 롤백시킴
    @Transactional(rollbackFor = Exception.class)
    public Company add(Company company){
        companyMapper.insert(company);
        // add company into legacy system
        if(true) {
            throw new RuntimeException("Legacy Exception");
        }
        return company;
    }
}
