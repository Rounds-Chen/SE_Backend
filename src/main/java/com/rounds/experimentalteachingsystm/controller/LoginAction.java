package com.rounds.experimentalteachingsystm.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.rounds.experimentalteachingsystm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginAction {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/doLogin")
    public Map<String, Integer> doLogin(String username, String password) {
        return loginService.doLogin(username,password);
    }

    @GetMapping("/checkUser")
    public boolean checkUser(String userID){
        return loginService.checkID(userID);
    }

}
