package com.rounds.experimentalteachingsystm.controller;


import com.rounds.experimentalteachingsystm.service.ClassService;
import com.rounds.experimentalteachingsystm.service.StuGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
@RestController
@RequestMapping("//class-entity")
public class ClassAction {
    @Autowired
    ClassService classService;
}

