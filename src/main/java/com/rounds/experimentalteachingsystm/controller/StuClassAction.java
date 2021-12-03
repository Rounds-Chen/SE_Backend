package com.rounds.experimentalteachingsystm.controller;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.rounds.experimentalteachingsystm.entity.StuClassEntity;
import com.rounds.experimentalteachingsystm.entity.StudentEntity;
import com.rounds.experimentalteachingsystm.service.StuClassService;
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
@RequestMapping("//stuClassEntity")
public class StuClassAction {
    @Autowired
    StuClassService stuClassService;

    /**
     * 在班级中添加学生
     * @param studentId id
     * @param newClassId 新班级编号
     * @param oldClassId 旧班级编号
     * @return
     */
    @PostMapping("/updateStuClass")
    public AjaxJson addStuToClass(String studentId, Integer oldClassId,Integer newClassId){
        LambdaUpdateWrapper<StuClassEntity> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(StuClassEntity::getStudentId,studentId).eq(StuClassEntity::getClassId,oldClassId).set(StuClassEntity::getClassId,newClassId);

        try{
            if(stuClassService.update(wrapper)){
                return AjaxJson.getSuccess();
            }
            else
                return AjaxJson.getError();
        }
        catch(Exception e){
            return AjaxJson.getError(e.toString());
        }
    }

}

