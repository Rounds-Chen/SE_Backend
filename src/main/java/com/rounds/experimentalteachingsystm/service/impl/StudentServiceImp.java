package com.rounds.experimentalteachingsystm.service.impl;

import com.rounds.experimentalteachingsystm.entity.StudentEntity;
import com.rounds.experimentalteachingsystm.mapper.StudentMapper;
import com.rounds.experimentalteachingsystm.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
