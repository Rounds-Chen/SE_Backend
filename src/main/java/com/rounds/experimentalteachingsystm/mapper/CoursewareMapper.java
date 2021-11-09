package com.rounds.experimentalteachingsystm.mapper;

import com.rounds.experimentalteachingsystm.entity.CoursewareEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rounds.experimentalteachingsystm.entity.ReportEntity;
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
 * @since 2021-11-08
 */
@Mapper
public interface CoursewareMapper extends BaseMapper<CoursewareEntity> {
    @Select("SELECT * FROM courseware WHERE course_id=#{id}")
    List<CoursewareEntity> getOne(@Param("id") int id);
}
