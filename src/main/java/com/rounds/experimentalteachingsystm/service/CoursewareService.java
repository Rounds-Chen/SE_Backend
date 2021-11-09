package com.rounds.experimentalteachingsystm.service;

import com.rounds.experimentalteachingsystm.entity.CoursewareEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.rounds.experimentalteachingsystm.entity.ReportEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czy
 * @since 2021-11-08
 */
public interface CoursewareService extends IService<CoursewareEntity> {
    public List<CoursewareEntity> getOne(int id);
}
