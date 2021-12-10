package com.rounds.experimentalteachingsystm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rounds.experimentalteachingsystm.entity.ExperimentEntity;
import com.rounds.experimentalteachingsystm.entity.StuGradeEntity;
import com.rounds.experimentalteachingsystm.service.ReportService;
import com.rounds.experimentalteachingsystm.service.StuGradeService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-11-02
 */
@RestController
@RequestMapping("//stuGradeEntity")
@Api
public class StuGradeAction {
    @Autowired
    StuGradeService stuGradeService;

    /**
     * 获取某学生某门课的成绩
     * @param student_id 学生id
     * @param course_id 课程id
     * @return
     */
    @ApiOperation(value = "获取学生某门课程成绩")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student_id",value = "学生id",dataType = "String"),
            @ApiImplicitParam(name = "course_id",value = "课程id",dataType = "Integer")
    })
    @GetMapping("/getStuGradeByCourseId")
    AjaxJson getStuGradeByCourseId(String student_id,Integer course_id){
        LambdaQueryWrapper<StuGradeEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(StuGradeEntity::getCourseId,course_id).eq(StuGradeEntity::getStudentId,student_id);
        return AjaxJson.getSuccessData(stuGradeService.list(wrapper));
    }
}

