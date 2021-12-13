package com.rounds.experimentalteachingsystm.service;

import com.rounds.experimentalteachingsystm.entity.CourseEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
public interface CourseService extends IService<CourseEntity> {
    List<Integer> getStuAllCours(String id);
}
