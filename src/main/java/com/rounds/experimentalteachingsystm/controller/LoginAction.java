package com.rounds.experimentalteachingsystm.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.rounds.experimentalteachingsystm.entity.StudentEntity;
import com.rounds.experimentalteachingsystm.entity.TeacherEntity;
import com.rounds.experimentalteachingsystm.service.LoginService;
import com.rounds.experimentalteachingsystm.service.StudentService;
import com.rounds.experimentalteachingsystm.service.TeacherService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.repository.util.QueryExecutionConverters;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.code.kaptcha.impl.DefaultKaptcha;


@RestController
@RequestMapping("/login")
public class LoginAction {
    @Autowired
    private LoginService loginService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @Autowired
    DefaultKaptcha defaultKaptcha;

    /**
     *
     * @param req 登录请求（此时前端已经检测验证码正确）
     * @return 是否成功登陆
     */
    @PostMapping("/doLogin")
    public AjaxJson doLogin(HttpServletRequest req) {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String ip = req.getRemoteAddr();

        SaTokenInfo saTokenInfo=loginService.doLogin(username,password);
        // 账号密码错误
        if(saTokenInfo==null){
            return AjaxJson.getNotLogin();
        }
        else {
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", saTokenInfo.getTokenValue());
            tokenMap.put("tokenHead", saTokenInfo.getTokenName());
            return AjaxJson.getSuccessData(tokenMap);
        }
    }

    @GetMapping("/checkUser")
    public AjaxJson checkUser(String userID){
        return loginService.checkID(userID)?AjaxJson.getSuccess():AjaxJson.getError("账号不存在！");
    }

    @RequestMapping("/logOut")
    public void logOut(){StpUtil.logout();}


    /**
     * 获取图像验证码，没有时间有效期
     * @return codeText: String 验证码 codeImage：byte[] 图片字节流
     */
    @GetMapping("/getVeriCode")
    public AjaxJson getVeriCode(){
        byte[] captchaCodeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();

        try {
            // 生成验证码字符串
            String codeText = defaultKaptcha.createText();
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage codeImage = defaultKaptcha.createImage(codeText);
            ImageIO.write(codeImage, "jpg", jpegOutputStream);
            captchaCodeAsJpeg= jpegOutputStream.toByteArray();
            jpegOutputStream.close();
            JSONObject res=new JSONObject();
            res.put("codeText",codeText);
            res.put("codeImage",captchaCodeAsJpeg);
            return AjaxJson.getSuccessData(res); //成功生成并返回验证码
        } catch (IllegalArgumentException | IOException e) {

            return AjaxJson.getError(); //验证码生成失败
        }


    }

    /**
     * 重置密码
     * @param id 用户id
     * @param flag 用户身份 1：教师，0：学生
     * @param pwd 新密码
     * @return
     */
    @PostMapping("/editPwd")
    public AjaxJson editPassword(String id,boolean flag,String pwd){

        if(flag) {
            LambdaUpdateWrapper<TeacherEntity> wrapper=new LambdaUpdateWrapper<>();
            wrapper.eq(TeacherEntity::getTeacherId,id).set(TeacherEntity::getTeacherPwd,pwd);
            if(!teacherService.update(wrapper)){
                return AjaxJson.getError();
            }
            else{
                return AjaxJson.getSuccessData(teacherService.getById(id).getTeacherPwd());
            }
        }else{
            LambdaUpdateWrapper<StudentEntity> wrapper=new LambdaUpdateWrapper<>();
            wrapper.eq(StudentEntity::getStudentId,id).set(StudentEntity::getStudentPwd,pwd);
            if(!studentService.update(wrapper)) {
                return AjaxJson.getError();
            }else{
                return AjaxJson.getSuccessData(studentService.getById(id).getStudentPwd());
            }
        }

    }

    /**
     * 获取旧密码
     * @param id 用户id
     * @param flag 1——教师；0——学生
     * @return
     */
    @GetMapping("/getPwd")
    public AjaxJson getPassword(String id,Boolean flag){
        Map<String,String> ans=new HashMap<>();
        if(flag) {
            TeacherEntity entity=teacherService.getById(id);
            if(entity==null){
                return AjaxJson.getError();
            }
            ans.put("password",entity.getTeacherPwd());
        }else{
            StudentEntity entity=studentService.getById(id);
            if(studentService.getById(id)==null){
                return AjaxJson.getError();
            }
            ans.put("password",entity.getStudentPwd());
        }
        return AjaxJson.getSuccessData(ans);

    }

}
