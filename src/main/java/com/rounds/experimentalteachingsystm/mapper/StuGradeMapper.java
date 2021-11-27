package com.rounds.experimentalteachingsystm.mapper;

import com.rounds.experimentalteachingsystm.entity.CoursewareEntity;
import com.rounds.experimentalteachingsystm.entity.StuGradeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author czy
 * @since 2021-11-02
 */
@Mapper
public interface StuGradeMapper extends BaseMapper<StuGradeEntity> {
    @Select("SELECT * FROM stu_grade WHERE student_id=#{student_id} AND course_id=#{course_id}")
    List<StuGradeEntity> getOne(@Param("student_id") String student_id,@Param("course_id") String course_id);
}
