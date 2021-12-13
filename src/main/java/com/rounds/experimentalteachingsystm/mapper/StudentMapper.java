package com.rounds.experimentalteachingsystm.mapper;

import com.rounds.experimentalteachingsystm.entity.StuClassCoursEntity;
import com.rounds.experimentalteachingsystm.entity.StudentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
@Mapper
public interface StudentMapper extends BaseMapper<StudentEntity> {

    @Select("SELECT student_name,student_id,class_id,course_id FROM student natural join stu_class natural join class" )
    public List<StuClassCoursEntity> getStuClassCours();

}
