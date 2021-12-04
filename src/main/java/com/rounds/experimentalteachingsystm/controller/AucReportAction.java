package com.rounds.experimentalteachingsystm.controller;


import com.rounds.experimentalteachingsystm.entity.AucReportEntity;
import com.rounds.experimentalteachingsystm.service.AucReportService;
import com.rounds.experimentalteachingsystm.service.FileStorageService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
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
@RequestMapping("//aucReportEntity")
public class AucReportAction {
    @Resource
    FileStorageService fileStorageService;

    @Autowired
    AucReportService aucReportService;

    /**
     * 上传实验报告
     * @param stuId 学生id
     * @param aucId 拍卖id
     * @param file 文件
     * @return
     */
    @PostMapping("//postReport")
    AjaxJson submitReport(String stuId, Integer aucId, MultipartFile file){
            String filePath=fileStorageService.upload(file);
            String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

//            Map<String,String> ans=new HashMap<>();
            if(null!=filePath){
                AucReportEntity entity=new AucReportEntity();
                entity.setAuctionId(aucId);
                entity.setStudentId(stuId);
                entity.setFileUrl(filePath);

//                aucReportService.save(entity);
                return AjaxJson.getSuccess();
            }else{
                return AjaxJson.getError();
            }
    }

}

