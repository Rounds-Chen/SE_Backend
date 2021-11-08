package com.rounds.experimentalteachingsystm.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.ExperimentEntity;
import com.rounds.experimentalteachingsystm.service.ExperimentService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
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
public class ExperimentAction {
    @Autowired
    ExperimentService experimentService;

    @GetMapping("/getAll")
    AjaxJson getAllExper(Integer courseId){
        LambdaQueryWrapper<ExperimentEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ExperimentEntity::getCourseId,courseId);

        return AjaxJson.getSuccessData(experimentService.list(wrapper));
    }

    @PostMapping("/setWeights")
    AjaxJson setWeights(String exp){
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

