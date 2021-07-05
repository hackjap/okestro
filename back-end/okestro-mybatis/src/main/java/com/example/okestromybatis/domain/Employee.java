package com.example.okestromybatis.domain;

import lombok.Data;

@Data // lombook 을 통한 get/setter 생략
public class Employee {
    private int id;
    private int companyId;
    private String name;
    private String address;
}
