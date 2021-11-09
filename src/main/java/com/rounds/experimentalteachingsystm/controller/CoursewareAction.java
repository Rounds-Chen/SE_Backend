package com.rounds.experimentalteachingsystm.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.CoursewareEntity;
import com.rounds.experimentalteachingsystm.entity.ReportEntity;
import com.rounds.experimentalteachingsystm.service.CoursewareService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-10-26
 */
@RestController
@RequestMapping("//courseware-entity")
public class CoursewareAction {
    @Autowired
    private CoursewareService coursewareService;
    @GetMapping("//getCourseware")
    AjaxJson getCoursewareOfStu(String id){
        LambdaUpdateWrapper<CoursewareEntity> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(CoursewareEntity::getCourseId,id);

        List<CoursewareEntity> ans;
        try{
            ans=coursewareService.list();
        }
        catch (Exception e){
            System.out.println(e);
            return AjaxJson.getError();
        }

        return AjaxJson.getSuccessData(ans);
    }
}

