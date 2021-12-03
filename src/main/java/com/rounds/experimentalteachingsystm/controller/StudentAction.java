package com.rounds.experimentalteachingsystm.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.StudentEntity;
import com.rounds.experimentalteachingsystm.entity.TeacherEntity;
import com.rounds.experimentalteachingsystm.service.StudentService;
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
 * @since 2021-10-25
 */
@RestController
@RequestMapping("//studentEntity")
public class StudentAction {
    @Autowired
    StudentService studentService;

    /**
     * 修改学生性别
     * @param gender 性别
     * @param id id
     * @return
     */
    @PostMapping("/editGender")
    public AjaxJson editGender(boolean gender,String id){
        LambdaUpdateWrapper<StudentEntity> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(StudentEntity::getStudentId,id).set(StudentEntity::getGender,gender);

        try {
            if(studentService.update(wrapper)){
                return AjaxJson.getSuccessData(studentService.getById(id).getGender());
            };
            return AjaxJson.getError();
        }
        catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError();
        }

    }


    /**
     * 修改学生邮箱
     * @param addr 邮箱
     * @param id id
     * @return
     */
    @PostMapping("/editMailAddr")
    public AjaxJson editMailAddr(String addr,String id){
        LambdaUpdateWrapper<StudentEntity> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(StudentEntity::getStudentId,id).set(StudentEntity::getMailAddr,addr);

        try {
            if(studentService.update(wrapper)){
                return AjaxJson.getSuccessData(studentService.getById(id).getMailAddr());
            };
            return AjaxJson.getError();
        }
        catch (Exception e){
            e.printStackTrace();
            return AjaxJson.getError();
        }
    }



}

