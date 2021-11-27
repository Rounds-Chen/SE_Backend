package com.rounds.experimentalteachingsystm.service;

import com.rounds.experimentalteachingsystm.entity.ReportEntity;
import com.rounds.experimentalteachingsystm.entity.StuGradeEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czy
 * @since 2021-11-02
 */
public interface StuGradeService extends IService<StuGradeEntity> {
    public List<StuGradeEntity> getOne(String student_id,String course_id);

}
