package com.rounds.experimentalteachingsystm.controller;


import com.rounds.experimentalteachingsystm.entity.CourseEntity;
import com.rounds.experimentalteachingsystm.service.CourseService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
@RestController
@Api
@RequestMapping("//courseEntity")
public class CourseAction {
    @Autowired
    CourseService courseService;


    /**
     * 获取所有课程
     * @return
     */
    @GetMapping("//getAll")
    @ApiOperation(value = "获取所有课程")
    AjaxJson getAllCourses(){
        return AjaxJson.getSuccessData(courseService.list());
    }

    @PostMapping("//postCourse")
    @ApiOperation(value = "发布新的课程")
    AjaxJson  postCourse(CourseEntity courseEntity){
        boolean flg=courseService.save(courseEntity);
        if(flg) return AjaxJson.getSuccess();
        else return AjaxJson.getError();
    }
    @GetMapping("//deleteCourse")
    @ApiOperation(value = "删除课程")
    @ApiImplicitParam(name = "id",value = "班级id",type = "int")
    AjaxJson deleteCourse(int id){
        return AjaxJson.getSuccessData(courseService.removeById(id));
    }

    @GetMapping("//getStuAllCours")
    @ApiOperation(value = "获取某学生所有课程")
    @ApiImplicitParam(name = "id",value = "学生id",dataType = "String")
    AjaxJson getStuAllCourses(String id){
        List<Integer> ans=courseService.getStuAllCours(id);
        System.out.println("某学生所有课程"+ans.toString());

        try {
            List<CourseEntity> res = new LinkedList<>();
            for (Integer i : ans) {
                res.add(courseService.getById(i));
            }
            return AjaxJson.getSuccessData(res);
        }catch (Exception e){
         return AjaxJson.getError(e.toString()) ;
        }

    }
}

