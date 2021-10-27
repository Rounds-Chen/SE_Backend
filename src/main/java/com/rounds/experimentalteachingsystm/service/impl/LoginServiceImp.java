package com.rounds.experimentalteachingsystm.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rounds.experimentalteachingsystm.entity.StudentEntity;
import com.rounds.experimentalteachingsystm.entity.TeacherEntity;
import com.rounds.experimentalteachingsystm.mapper.StudentMapper;
import com.rounds.experimentalteachingsystm.mapper.TeacherMapper;
import com.rounds.experimentalteachingsystm.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImp implements LoginService {

    @Resource
    private StudentMapper studentMapper;
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public boolean checkID(String id) {
        if(studentMapper.selectById(id)==null){
            return false;
        }
        return true;
    }

    @Override
    public Map<String, Integer> doLogin(String id, String pwd){
        QueryWrapper<StudentEntity> wrapper_1=new QueryWrapper<>();
        Map<String,String> map_1=new HashMap<>();
        map_1.put("student_id",id);
        map_1.put("student_pwd",pwd);
        wrapper_1.allEq(map_1);

        QueryWrapper<TeacherEntity> wrapper_2=new QueryWrapper<>();
        Map<String,String> map_2=new HashMap<>();
        map_2.put("teacher_id",id);
        map_2.put("teacher_pwd",pwd);
        wrapper_2.allEq(map_2);

        Map<String,Integer> res=new HashMap<>();
        if(studentMapper.selectOne(wrapper_1)!=null||teacherMapper.selectOne(wrapper_2)!=null){
            StpUtil.login(id);


            res.put("code",200);
            return res;
        }
        res.put("code",400);
        return res;
    }
}
