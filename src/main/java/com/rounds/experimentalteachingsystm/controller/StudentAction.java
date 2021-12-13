package com.rounds.experimentalteachingsystm.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.StuClassCoursEntity;
import com.rounds.experimentalteachingsystm.entity.StudentEntity;
import com.rounds.experimentalteachingsystm.entity.TeacherEntity;
import com.rounds.experimentalteachingsystm.service.CourseService;
import com.rounds.experimentalteachingsystm.service.StudentService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
@Api
public class StudentAction {
    @Autowired
    StudentService studentService;

    @Autowired
    CourseService courseService;

    /**
     * 修改学生性别
     * @param gender 性别
     * @param id id
     * @return
     */
    @PostMapping("/editGender")
    @ApiOperation(value = "修改学生性别")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "gender",value = "新性别",dataType = "boolean"),
            @ApiImplicitParam(name = "id",value = "学生id",dataType = "String")
    })
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
    @ApiOperation(value = "修改学生邮箱")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addr",value = "邮箱地址",dataType = "String"),
            @ApiImplicitParam(name = "id",value = "学生id",dataType = "String")
    })
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

    @GetMapping("/getStuClassCours")
    @ApiOperation(value = "获取学生课程班级信息")
    public AjaxJson getStuClassCours(){
        List<StuClassCoursEntity> res=studentService.getStuClassCours();
        List<Map<String,String>> ans=new LinkedList<>();
        try{
        for(StuClassCoursEntity item :res ){
            Integer courseId=item.getCourse_name();
            Map<String,String> tmp=new HashMap<>();
            tmp.put("student_name",item.getStu_name());
            tmp.put("student_id",item.getStudent_id());
            tmp.put("class_id",String.valueOf(item.getClass_id()));
            tmp.put("course_name",courseService.getById(courseId).getCourseName());

            ans.add(tmp);
        }
        return AjaxJson.getSuccessData(ans);
        }
        catch (Exception e){
            return AjaxJson.getError(e.toString());
        }


    }



}

