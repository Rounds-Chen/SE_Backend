package com.rounds.experimentalteachingsystm.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.StudentEntity;
import com.rounds.experimentalteachingsystm.entity.TeacherEntity;
import com.rounds.experimentalteachingsystm.service.TeacherService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

