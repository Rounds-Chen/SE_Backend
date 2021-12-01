package com.rounds.experimentalteachingsystm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rounds.experimentalteachingsystm.entity.ExperimentEntity;
import com.rounds.experimentalteachingsystm.entity.StuGradeEntity;
import com.rounds.experimentalteachingsystm.service.ReportService;
import com.rounds.experimentalteachingsystm.service.StuGradeService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
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
public class StuGradeAction {
    @Autowired
    StuGradeService stuGradeService;

    @GetMapping("/getStuGradeByCourseId")
    AjaxJson getStuGradeByCourseId(String student_id,String course_id){
        LambdaQueryWrapper<StuGradeEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(StuGradeEntity::getCourseId,course_id).eq(StuGradeEntity::getStudentId,student_id);
        return AjaxJson.getSuccessData(stuGradeService.list(wrapper));
    }
}

