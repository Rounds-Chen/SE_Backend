package com.rounds.experimentalteachingsystm.service.impl;

import com.rounds.experimentalteachingsystm.entity.StudentEntity;
import com.rounds.experimentalteachingsystm.mapper.StudentMapper;
import com.rounds.experimentalteachingsystm.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
@Service
public class StudentServiceImp extends ServiceImpl<StudentMapper, StudentEntity> implements StudentService {

    @Autowired
    StudentService studentService;

    @Override
    public List<Map<String, String>> getStuClassCours() {
        List<Map<String,String>> res=new LinkedList<>();
                res=studentService.getStuClassCours();
        System.out.println("测试"+res.toString());
        return res;
    }
}
