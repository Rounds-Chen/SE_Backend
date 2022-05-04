package com.rounds.experimentalteachingsystm.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.AucReport2Entity;
import com.rounds.experimentalteachingsystm.entity.ReportUploaderEntity;
import com.rounds.experimentalteachingsystm.service.AucReport2Service;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2022-01-08
 */
@RestController
@RequestMapping("//aucReport2Entity")
public class AucReport2Action {
    @Autowired
    private AucReport2Service aucReport2Service;

    @PostMapping(value="/markdown2pdf")
    AjaxJson markdownToPdf(@RequestParam("studentId") String studentId,
                           @RequestParam("name") String name,
                           @RequestParam("intro") String intro,
                           @RequestParam("procedures") String procedures,
                           @RequestParam("analysis") String analysis,
                           @RequestParam("images") MultipartFile[] images){
        try{
//            System.out.println(reportUploader.getStudentId());
//            System.out.println(reportUploader.getImages());
//            aucReport2Service.markdownToPdf(reportUploader.getStudentId(),
//                    reportUploader.getName(),
//                    reportUploader.getIntro(),
//                    reportUploader.getProcedures(),
//                    reportUploader.getAnalysis(),
//                    reportUploader.getImages());
            System.out.println(studentId);
            System.out.println(images);
            aucReport2Service.markdownToPdf(studentId,name,intro,procedures,analysis,images);
            return AjaxJson.getSuccess();
        }
        catch (Exception e){
            System.out.println(e.toString());
            return AjaxJson.getError(e.toString());
        }
    }
}

