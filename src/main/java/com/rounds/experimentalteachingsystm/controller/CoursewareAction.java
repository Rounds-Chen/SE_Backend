package com.rounds.experimentalteachingsystm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.CoursewareEntity;
import com.rounds.experimentalteachingsystm.service.CourseService;
import com.rounds.experimentalteachingsystm.service.CoursewareService;
import com.rounds.experimentalteachingsystm.service.FileStorageService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
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
@Api
public class CoursewareAction {
    @Autowired
    CoursewareService coursewareService;

    @Autowired
    CourseService courseService;

    @Autowired
    private FileStorageService fileStorageService;

    /**
     * 获取某课件
     * @param id 课件id
     * @return
     */
    @GetMapping("//getCoursewareById")
    @ApiOperation(value = "根据id获取某课件")
    @ApiImplicitParam(name = "id",value = "课件id",dataType = "Integer")
    public AjaxJson getCoursewareById(Integer id){

        try{
           CoursewareEntity ans=coursewareService.getById(id);

            Map<String,String> tmp=new HashMap<>();
            tmp.put("name",ans.getCoursewareName());
            tmp.put("updateTime",String.valueOf(ans.getTime()));
            tmp.put("link",ans.getLink());
            tmp.put("type",ans.getType());
            tmp.put("coursename",courseService.getById(id).getCourseName());

            return AjaxJson.getSuccessData(tmp);
        }
        catch (Exception e){
            System.out.println(e);
            return AjaxJson.getError();
        }

    }

    /**
     * 获取某课程所有课件
     * @param id 课程id
     * @return
     */
    @GetMapping("/getCoursewares")
    @ApiOperation(value = "获取某课程所有课件")
    @ApiImplicitParam(name = "id",value = "课程id",dataType = "Integer")
    public AjaxJson getCoursewares(Integer id){
        try {
            LambdaQueryWrapper<CoursewareEntity> wrapper=new LambdaQueryWrapper<>();
            wrapper.eq(CoursewareEntity::getCourseId,id);
            List<CoursewareEntity> entity = coursewareService.list(wrapper);
            List<Map<String,String>> res=new LinkedList<>();

            for(CoursewareEntity e:entity){
                Map<String,String> tmp=new HashMap<>();
                tmp.put("name",e.getCoursewareName());
                tmp.put("updateTime",String.valueOf(e.getTime()));
                tmp.put("link",e.getLink());
                tmp.put("type",e.getType());
                tmp.put("coursename",courseService.getById(id).getCourseName());

                res.add(tmp);

            }
            return AjaxJson.getSuccessData(res);
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

    /**
     * 上传课件
     * @param id 课程id
     * @param file 课件文件
     * @return
     */
    @PostMapping("/postCourseware")
    @ApiOperation(value = "上传课件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "课程id",dataType = "Integer"),
            @ApiImplicitParam(name = "file",value = "文件",dataType = "MultipartFile")
    })
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
    @ApiOperation(value = "删除课件")
    @ApiImplicitParam(name = "id",value = "课件id",type = "Integer")
    public AjaxJson deleteCourseware(@ApiParam(value = "课件id") Integer id){
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

