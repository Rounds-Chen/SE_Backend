package com.rounds.experimentalteachingsystm.service.impl;

import com.rounds.experimentalteachingsystm.entity.ReportEntity;
import com.rounds.experimentalteachingsystm.entity.StuGradeEntity;
import com.rounds.experimentalteachingsystm.mapper.ReportMapper;
import com.rounds.experimentalteachingsystm.mapper.StuGradeMapper;
import com.rounds.experimentalteachingsystm.service.StuGradeService;
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
 * @since 2021-11-02
 */
@Service
public class StuGradeServiceImp extends ServiceImpl<StuGradeMapper, StuGradeEntity> implements StuGradeService {
    @Resource
    StuGradeMapper stuGradeMapper;

    @Override
    public List<StuGradeEntity> getOne(String student_id,String course_id) {
        return stuGradeMapper.getOne(student_id,course_id);
    }
}
