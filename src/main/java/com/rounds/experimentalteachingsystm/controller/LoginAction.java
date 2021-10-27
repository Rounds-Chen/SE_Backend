package com.rounds.experimentalteachingsystm.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.rounds.experimentalteachingsystm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginAction {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/doLlogin")
    public boolean doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("se".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return true;
        }
        return false;
    }

    @GetMapping("/checkUser")
    public boolean checkUser(String userID){
        return loginService.checkID(userID);
    }

}
