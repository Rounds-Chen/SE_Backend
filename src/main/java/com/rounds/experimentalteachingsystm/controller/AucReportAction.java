package com.rounds.experimentalteachingsystm.controller;


import com.alibaba.fastjson.JSONObject;
import com.rounds.experimentalteachingsystm.entity.AucReport2Entity;
import com.rounds.experimentalteachingsystm.entity.AucReportEntity;
import com.rounds.experimentalteachingsystm.service.AucReport2Service;
import com.rounds.experimentalteachingsystm.service.AucReportService;
import com.rounds.experimentalteachingsystm.service.FileStorageService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("//aucReportEntity")
public class AucReportAction {
    @Resource
    FileStorageService fileStorageService;

    @Autowired
    AucReportService aucReportService;

    @Autowired
    AucReport2Service aucReport2Service;


    @RequestMapping("//getReports")
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
            @ApiImplicitParam(name="body",value = "页面内容",dataType = "String")
    })
    AjaxJson submitReport(@RequestBody String body) throws UnsupportedEncodingException, SQLException {
        JSONObject req=JSONObject.parseObject(body);
        String name=req.getString("name");
        String id=req.getString("id");
        Blob content=new SerialBlob(req.getString("content").getBytes("GBK"));

        AucReport2Entity entity=new AucReport2Entity();
        entity.setContent(content);
        entity.setId(id);
        entity.setName(name);

        try{
            aucReport2Service.save(entity);
            return AjaxJson.getSuccess();
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }

    }

}

