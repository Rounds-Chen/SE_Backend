package com.rounds.experimentalteachingsystm.service;

import com.rounds.experimentalteachingsystm.entity.StudentEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
public interface StudentService extends IService<StudentEntity> {

    public List<Map<String,String>> getStuClassCours();
}
