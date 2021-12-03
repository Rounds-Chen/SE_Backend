package com.rounds.experimentalteachingsystm.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.CoursewareEntity;
import com.rounds.experimentalteachingsystm.service.CoursewareService;
import com.rounds.experimentalteachingsystm.service.FileStorageService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-10-26
 */
@RestController
@RequestMapping("//coursewareEntity")
public class CoursewareAction {
    @Autowired
    CoursewareService coursewareService;

    @Autowired
    private FileStorageService fileStorageService;

    /**
     * 获取某课程所有课件
     * @param id 课程id
     * @return
     */
    @GetMapping("//getCourseware")
    public AjaxJson getCourseware(Integer id){
        LambdaUpdateWrapper<CoursewareEntity> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(CoursewareEntity::getCourseId,id);

        List<CoursewareEntity> ans;
        try{
            ans=coursewareService.list(wrapper);
        }
        catch (Exception e){
            System.out.println(e);
            return AjaxJson.getError();
        }
        return AjaxJson.getSuccessData(ans);
    }

    /**
     * 获取某课件
     * @param id 课件id
     * @return
     */
    @GetMapping("/getCoursewareById")
    public AjaxJson getCoursewareById(Integer id){
        CoursewareEntity entity=coursewareService.getById(id);
        if(entity!=null){
            return AjaxJson.getSuccessData(entity);
        }
        return AjaxJson.getError();
    }

    /**
     * 上传课件
     * @param id 课程id
     * @param file 课件文件
     * @return
     */
    @PostMapping("/postCourseware")
    public AjaxJson uploadCourseware(Integer id, MultipartFile file){
        String filePath=fileStorageService.upload(file);
        String suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        Map<String,String> res=new HashMap<>();
        if(null!=filePath){
            CoursewareEntity newCourseware=new CoursewareEntity();
            newCourseware.setCoursewareName(file.getOriginalFilename());
            newCourseware.setLink(filePath);
            newCourseware.setCourseId(id);
            newCourseware.setType(suffix);
            coursewareService.save(newCourseware);

            res.put("filePath",filePath);
            return AjaxJson.getSuccessData(res);
        }
        else{
            return AjaxJson.getError();
        }
    }

    /**
     * 根据id删除课件
     * @param id
     * @return
     */
    @PostMapping("/deleteCourseWare")
    public AjaxJson deleteCourseware(Integer id){
        String fileLink=coursewareService.getById(id).getLink();
        fileStorageService.delete(fileLink);

        try{
            coursewareService.removeById(id);
            return AjaxJson.getSuccess();
        }
        catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError();
        }
    }
}

