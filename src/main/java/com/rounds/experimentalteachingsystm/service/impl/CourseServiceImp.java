package com.rounds.experimentalteachingsystm.service.impl;

import com.rounds.experimentalteachingsystm.entity.CourseEntity;
import com.rounds.experimentalteachingsystm.mapper.CourseMapper;
import com.rounds.experimentalteachingsystm.mapper.StuClassMapper;
import com.rounds.experimentalteachingsystm.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
@Service
public class CourseServiceImp extends ServiceImpl<CourseMapper, CourseEntity> implements CourseService {
    @Autowired
    StuClassMapper stuClassMapper;

    @Autowired
    CourseMapper courseMapper;

    public List<Integer> getStuAllCours(String id){
        return stuClassMapper.getStuAllCours(id);
    }

}
