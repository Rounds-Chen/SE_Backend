package com.rounds.experimentalteachingsystm.controller;


import com.rounds.experimentalteachingsystm.entity.CourseEntity;
import com.rounds.experimentalteachingsystm.service.CourseService;
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
 * @since 2021-10-25
 */
@RestController
@RequestMapping("//courseEntity")
public class CourseAction {
    @Autowired
    CourseService courseService;

    @GetMapping("//getAll")
    AjaxJson getAllCourses(){
        return AjaxJson.getSuccessData(courseService.list());
    }

}

