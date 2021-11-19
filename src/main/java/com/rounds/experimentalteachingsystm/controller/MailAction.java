package com.rounds.experimentalteachingsystm.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;


/*
1 正确发送邮件
2 from是啥
3 安全性保证？防止恶意注入？


 */
@RestController
@RequestMapping("/forgetPwd")
public class MailAction {
    @Resource
    private JavaMailSender mailSender;


    @Autowired
    @Qualifier("stringRedisTemplate")
    RedisTemplate<String,String> rt;

    @Autowired
    DefaultKaptcha defaultKaptcha;

    /**
     * 检验验证码是否正确
     * @param req
     * @return
     */
    @GetMapping("/veriMailCode")
    @ResponseBody
    public AjaxJson verifyCode(HttpServletRequest req,String inputCode) {
        String ip=req.getRemoteAddr();
        ValueOperations<String,String> forValue=rt.opsForValue();
        String true_code=forValue.get(ip+"_mail_veri_code");
        if(true_code==null) //验证码不存在或者过期
            return AjaxJson.getNoVericode();
        else if(!true_code.equals(inputCode)){ //验证码错误
            return AjaxJson.getInvalidCode();
        }
        return AjaxJson.getSuccess("验证码正确");// 验证通过
    }

    /**
     * 向to邮箱发送有效时间1min的验证码
     * @param to 收件邮箱
     * @param req 请求
     * @return
     */
    @GetMapping("/sendMailCode")
    public AjaxJson sendVeriCode(String to,HttpServletRequest req){
        String subject="密码重置验证码";
        String content="验证码获取失败"; //验证码
        String from ="1418621447@qq.com"; //发件人

        String ip=req.getRemoteAddr(); //请求的ip

        try {
            content  =  defaultKaptcha.createText();//获取验证码
            System.out.println(content);
            ValueOperations forValue = rt.opsForValue();
            forValue.set(ip+"_mail_veri_code", content);
            rt.expire(ip+"_mail_veri_code", 60*1000, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            return AjaxJson.getSuccess();
        } catch (Exception e) {
            System.out.println(e);
            return AjaxJson.getError(e.toString());
        }
    }

}
