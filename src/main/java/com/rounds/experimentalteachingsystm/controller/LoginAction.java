package com.rounds.experimentalteachingsystm.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import com.rounds.experimentalteachingsystm.service.LoginService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class LoginAction {
    @Autowired
    private LoginService loginService;

    @PostMapping("/doLogin")
    public AjaxJson doLogin(String username, String password) {
        return loginService.doLogin(username,password)?AjaxJson.getSuccess():AjaxJson.getNotLogin();
    }

    @GetMapping("/checkUser")
    public AjaxJson checkUser(String userID){
        return loginService.checkID(userID)?AjaxJson.getSuccess():AjaxJson.getError("账号不存在！");
    }

    @RequestMapping("/logOut")
    public void logOut(){StpUtil.logout();}


    @SaCheckLogin						// 注解式鉴权：当前会话必须登录才能通过
    @RequestMapping("atCheck")
    public AjaxJson atCheck() {
        System.out.println("======================= 进入方法，测试注解鉴权接口 ========================= ");
        System.out.println("只有通过注解鉴权，才能进入此方法");
//		StpUtil.checkActivityTimeout();
//		StpUtil.updateLastActivityToNow();
        return AjaxJson.getSuccess();
    }

}
