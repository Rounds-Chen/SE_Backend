package com.rounds.experimentalteachingsystm.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.ExperimentEntity;
import com.rounds.experimentalteachingsystm.service.ExperimentService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-11-01
 */
@RestController
@RequestMapping("//experimentEntity")
@Api
public class ExperimentAction {
    @Autowired
    ExperimentService experimentService;

//    @SaCheckLogin
    @GetMapping("/getAll")
    @ApiOperation(value = "获取某课程所有实验")
    @ApiImplicitParam(name = "courseId",value = "课程id",type = "Integer")
    AjaxJson getAllExper(@ApiParam(value = "课程id") Integer courseId){
        LambdaQueryWrapper<ExperimentEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ExperimentEntity::getCourseId,courseId);

        return AjaxJson.getSuccessData(experimentService.list(wrapper));
    }

    @PostMapping("/setWeights")
    @ApiOperation("设置实验权重")
    @ApiImplicitParam(name = "exp",value = "权重json序列化结果",type = "String")
    AjaxJson setWeights(@ApiParam(value = "权重json序列化结果") String exp){
        JSONObject experWeights=JSONObject.parseObject(exp);
        LambdaUpdateWrapper<ExperimentEntity> wrapper=new LambdaUpdateWrapper<>();

        try{
            for(Map.Entry entry:experWeights.entrySet()){
                Integer id=Integer.valueOf(entry.getKey().toString());
                float val=Float.parseFloat(experWeights.getString(String.valueOf(id)));
                wrapper.eq(ExperimentEntity::getExperId,id)
                        .set(ExperimentEntity::getWeight,val);
                experimentService.update(wrapper);
            }

        }
        catch(Exception e) {
            System.out.println(e);
            return AjaxJson.getError();
        }

        return AjaxJson.getSuccess();
    }

}

