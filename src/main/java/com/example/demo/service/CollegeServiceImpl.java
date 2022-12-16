package com.example.demo.service;

import com.example.demo.dao.CollegeMapper;
import com.example.demo.pojo.College;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {


    @Resource
    CollegeMapper collegeMapper;
    @Override
    public List<College> getColleges() {

        try {
            return collegeMapper.getColleges();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
