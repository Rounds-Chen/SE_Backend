package com.rounds.experimentalteachingsystm.mapper;


import com.rounds.experimentalteachingsystm.entity.CourseEntity;
import com.rounds.experimentalteachingsystm.entity.StuClassEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author czy
 * @since 2021-10-26
 */
@Mapper
public interface StuClassMapper extends BaseMapper<StuClassEntity> {

    @Select("SELECT course_id from stu_class natural join class WHERE student_id=#{id}")
    public List<Integer> getStuAllCours(@Param("id")String id);

}
