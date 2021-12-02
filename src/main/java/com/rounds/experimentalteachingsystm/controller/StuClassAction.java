package com.rounds.experimentalteachingsystm.controller;


import com.rounds.experimentalteachingsystm.entity.StuClassEntity;
import com.rounds.experimentalteachingsystm.service.CourseService;
import com.rounds.experimentalteachingsystm.service.StuClassService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-10-26
 */
@RestController
@RequestMapping("//stuClassEntity")
public class StuClassAction {
    @Autowired
    StuClassService stuClassService;

    @PostMapping("//postStuClass")
    AjaxJson postStuClass(StuClassEntity stuClassEntity){
        return AjaxJson.getSuccessData(stuClassService.save(stuClassEntity));
    }
    @PostMapping("//updateStuClass")
    AjaxJson updateStuClass(StuClassEntity stuClassEntity){
        boolean flg=stuClassService.updateById(stuClassEntity);
        if(flg) return AjaxJson.getSuccess();
        else return  AjaxJson.getError();
    }
}

