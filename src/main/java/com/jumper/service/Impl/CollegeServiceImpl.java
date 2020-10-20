package com.jumper.service.Impl;

import com.jumper.mapper.CollegeMapper;
import com.jumper.pojo.College;
import com.jumper.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    CollegeMapper collegeMapper;

    @Override
    public List<College> selectAllCollege() {
        return collegeMapper.selectAllCollege();
    }
}
