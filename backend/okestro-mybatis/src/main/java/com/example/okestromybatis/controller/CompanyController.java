package com.example.okestromybatis.controller;

import com.example.okestromybatis.mapper.CompanyMapper;
import com.example.okestromybatis.domain.Company;
import com.example.okestromybatis.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private CompanyService companyService;


    @PostMapping("")
    public Company post(@RequestBody Company company){

        companyMapper.insert(company);
//        companyService.add(company); transactional
        return company;
    }

    @GetMapping("")
    public List<Company> getAll(){
//        companyService.getAll();
        return companyMapper.getAll();
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable("id")int id){
        return companyMapper.getById(id);
    }
}
