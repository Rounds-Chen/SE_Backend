package com.rounds.experimentalteachingsystm.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.ExperimentEntity;
import com.rounds.experimentalteachingsystm.entity.ReportEntity;
import com.rounds.experimentalteachingsystm.mapper.ReportMapper;
import com.rounds.experimentalteachingsystm.service.ReportService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("//report-entity")
public class ReportAction {
    @Autowired
    ReportService reportService;

    @GetMapping("//getReport")
    AjaxJson getReportOfStu(String id){
        LambdaUpdateWrapper<ReportEntity> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(ReportEntity::getStudentId,id);

        List<ReportEntity> ans;
        try{
            ans=reportService.list();
        }
        catch (Exception e){
            System.out.println(e);
            return AjaxJson.getError();
        }

        return AjaxJson.getSuccessData(ans);
    }

}

