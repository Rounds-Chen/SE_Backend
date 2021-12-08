package com.rounds.experimentalteachingsystm.controller;


import com.rounds.experimentalteachingsystm.entity.ClassEntity;
import com.rounds.experimentalteachingsystm.service.ClassService;
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
 * @since 2021-12-04
 */
@RestController
@RequestMapping("//classEntity")
public class ClassAction {
    @Autowired
    ClassService classService;

    /**
     * 获取班级信息
     * @param id 班级id
     * @return
     */
    @GetMapping("/getClassInfos")
    AjaxJson getClassInfos(Integer id){
        ClassEntity entity=classService.getById(id);
        if(entity!=null){
            return AjaxJson.getSuccessData(entity);
        }
        return AjaxJson.getError();
    }

}

