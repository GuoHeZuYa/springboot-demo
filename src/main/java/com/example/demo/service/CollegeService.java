package com.example.demo.service;




import com.example.demo.pojo.College;

import java.util.List;

/**
 * service层，主要业务逻辑
 * 定义一个接口，并在CollegeServiceImpl中实现
 * 通常这样做但并不绝对
 * 也可以直接写类CollegeService
 */
public interface CollegeService {
    List<College> getColleges();
}
