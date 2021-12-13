package com.rounds.experimentalteachingsystm.service.impl;

import com.rounds.experimentalteachingsystm.entity.StuClassCoursEntity;
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
    StudentMapper studentMapper;

    @Override
    public List<StuClassCoursEntity> getStuClassCours() {
        List<StuClassCoursEntity> res=new LinkedList<>();
        res=studentMapper.getStuClassCours();
        System.out.println("测试"+res.toString());
        return res;
    }
}
