package com.rounds.experimentalteachingsystm.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.ExperimentEntity;
import com.rounds.experimentalteachingsystm.entity.ReportEntity;
import com.rounds.experimentalteachingsystm.mapper.ReportMapper;
import com.rounds.experimentalteachingsystm.service.ReportService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api
public class ReportAction {
    @Autowired
    ReportService reportService;

    /**
     * 获取某学生所有报告
     * @param id 学生id
     * @return
     */
    @GetMapping("//getReport")
    @ApiOperation(value = "获取某学生所有报告")
    AjaxJson getReportOfStu(@ApiParam(value = "学生id") String id){
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

