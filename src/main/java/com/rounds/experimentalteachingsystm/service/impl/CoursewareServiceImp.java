package com.rounds.experimentalteachingsystm.service.impl;

import com.rounds.experimentalteachingsystm.entity.CoursewareEntity;
import com.rounds.experimentalteachingsystm.mapper.CoursewareMapper;
import com.rounds.experimentalteachingsystm.mapper.ReportMapper;
import com.rounds.experimentalteachingsystm.service.CoursewareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czy
 * @since 2021-11-08
 */
@Service
public class CoursewareServiceImp extends ServiceImpl<CoursewareMapper, CoursewareEntity> implements CoursewareService {
    @Resource
    CoursewareMapper coursewareMapper;
    @Override
    public List<CoursewareEntity> getOne(int id) {
        return coursewareMapper.getOne(id);
    }
}
