package com.rounds.experimentalteachingsystm.controller;


import com.rounds.experimentalteachingsystm.entity.ClassEntity;
import com.rounds.experimentalteachingsystm.service.ClassService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api
@RequestMapping("//classEntity")
public class ClassAction {
    @Autowired
    ClassService classService;

    /**
     * 获取班级信息
     * @param id 班级id
     * @return
     */
    @ApiOperation(value="获取班级信息")
    @GetMapping("/getClassInfos")
    @ApiImplicitParam(name="id",value = "班级id",type = "Integer")
    AjaxJson getClassInfos(@ApiParam(name="id",value = "班级id")Integer id){
        ClassEntity entity=classService.getById(id);
        if(entity!=null){
            return AjaxJson.getSuccessData(entity);
        }
        return AjaxJson.getError();
    }

}

