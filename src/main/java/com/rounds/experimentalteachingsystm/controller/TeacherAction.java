package com.rounds.experimentalteachingsystm.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.StudentEntity;
import com.rounds.experimentalteachingsystm.entity.TeacherEntity;
import com.rounds.experimentalteachingsystm.service.TeacherService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.Validate;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-10-26
 */
@RestController
@RequestMapping("//teacherEntity")
@Api
public class TeacherAction {

    @Autowired
    TeacherService teacherService;

    /**
     * 修改教师性别
     * @param gender 教师性别
     * @param id 教师id
     * @return
     */
    @PostMapping("/editGender")
    @ApiOperation(value = "修改教师性别")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gender",value = "性别",dataType = "boolean"),
            @ApiImplicitParam(name = "id",value = "教师id",dataType = "String")
    })
    public AjaxJson editGender(boolean gender,String id){
        LambdaUpdateWrapper<TeacherEntity> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(TeacherEntity::getTeacherId,id).set(TeacherEntity::getGender,gender);

        try {
            if(teacherService.update(wrapper)){
                return AjaxJson.getSuccessData(teacherService.getById(id).getGender());
            };
            return AjaxJson.getError();
        }
        catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError();
        }

    }


    /**
     * 修改教师邮箱
     * @param addr 教师邮箱
     * @param id 教师id
     * @return
     */
    @ApiOperation(value = "修改教师邮箱")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addr",value = "邮箱",dataType = "String"),
            @ApiImplicitParam(name = "id",value = "教师id",dataType = "String")
    })
    @PostMapping("/editMailAddr")
    public AjaxJson editMailAddr(String addr,String id){
        LambdaUpdateWrapper<TeacherEntity> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(TeacherEntity::getTeacherId,id).set(TeacherEntity::getMailAddr,addr);

        try {
            if(teacherService.update(wrapper)){
                return AjaxJson.getSuccessData(teacherService.getById(id).getMailAddr());
            };
            return AjaxJson.getError();
        }
        catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError();
        }
    }

    /**
     * 设置助教批改权限
     * @param id 助教id
     * @param valid 是否有权限
     * @return
     */
    @ApiOperation(value = "设置助教批改权限")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "助教id",dataType = "String"),
            @ApiImplicitParam(name = "valid",value = "是否有批改权限",dataType = "boolean")
    })
    @PostMapping("/setAuthority")
    public AjaxJson setAuthority(String id,boolean valid){
        LambdaUpdateWrapper<TeacherEntity> wrapper =new LambdaUpdateWrapper<>();
        wrapper.eq(TeacherEntity::getTeacherId,id).set(TeacherEntity::getAuthority,valid);

        try{
           if(!teacherService.update(wrapper)){
               return AjaxJson.getError();
           }
           else{
               return AjaxJson.getSuccessData(teacherService.getById(id).getAuthority());
           }
        }
        catch(Exception e){
            e.printStackTrace();
            return AjaxJson.getError();
        }

    }

}

