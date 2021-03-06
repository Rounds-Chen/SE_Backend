package com.rounds.experimentalteachingsystm.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.AucReport2Entity;
import com.rounds.experimentalteachingsystm.entity.AucReportEntity;
import com.rounds.experimentalteachingsystm.service.AucReport2Service;
import com.rounds.experimentalteachingsystm.service.AucReportService;
import com.rounds.experimentalteachingsystm.service.FileStorageService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialBlob;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-12-01
 */
@RestController
@Api
@RequestMapping("/auction/aucReportEntity")
public class AucReportAction {
    @Resource
    FileStorageService fileStorageService;

    @Autowired
    AucReportService aucReportService;

    @Autowired
    AucReport2Service aucReport2Service;

    @PostMapping("//reviewReport")
    @ApiOperation(value = "批改实验报告")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "学生id",type="String"),
            @ApiImplicitParam(name = "score",value = "成绩",type = "Integer")
    })
    AjaxJson reviewReport(String id,Integer score){
        LambdaUpdateWrapper<AucReport2Entity> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(AucReport2Entity::getId,id).set(AucReport2Entity::getScore,score);
        try{
            if(aucReport2Service.update(wrapper)){
                return AjaxJson.getSuccess();
            }else{
                return AjaxJson.getError();
            }
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @GetMapping("//getReport")
    @ApiOperation(value = "获取某学生实验报告")
    @ApiImplicitParam(name = "id",value = "学生id",type = "String")
    AjaxJson getReportById( String id){
        LambdaQueryWrapper<AucReport2Entity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(AucReport2Entity::getId,id);
        try{
            AucReport2Entity entity=aucReport2Service.getOne(wrapper);
            return AjaxJson.getSuccessData(entity);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @GetMapping("//getReports")
    @ApiOperation(value = "获取所有实验报告")
    AjaxJson getReports(){
        try {
            List<AucReport2Entity> res = aucReport2Service.list();
            return AjaxJson.getSuccessData(res);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    @PostMapping("//postReport")
    @ApiOperation(value="提交报告")
    @ApiImplicitParams({
            @ApiImplicitParam(name="body",value = "页面内容",type = "string")
    })
    AjaxJson submitReport(@RequestBody String body) throws UnsupportedEncodingException, SQLException {
        JSONObject reqs=JSONObject.parseObject(body);
        JSONObject req=reqs.getJSONObject("body");
        String name=req.getString("name");
        String id=req.getString("id");
        String title=req.getString("title");
        String content=req.getString("content");

        AucReport2Entity entity=new AucReport2Entity();
        entity.setContent(content);
        entity.setId(id);
        entity.setName(name);
        entity.setAucTitle(title);

        try{
            aucReport2Service.save(entity);
            return AjaxJson.getSuccess();
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }

    }

}

