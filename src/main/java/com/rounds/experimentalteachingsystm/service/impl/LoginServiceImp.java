package com.rounds.experimentalteachingsystm.service.impl;

import com.rounds.experimentalteachingsystm.mapper.StudentMapper;
import com.rounds.experimentalteachingsystm.mapper.TeacherMapper;
import com.rounds.experimentalteachingsystm.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImp implements LoginService {

    @Resource
    private StudentMapper studentMapper;
//    private TeacherMapper teacherMapper;

    @Override
    public boolean checkID(String id) {
        if(studentMapper.selectById(id)==null){
            return false;
        }
        return true;
    }
}
