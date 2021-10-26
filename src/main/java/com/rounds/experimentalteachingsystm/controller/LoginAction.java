package com.rounds.experimentalteachingsystm.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginAction {

    @RequestMapping("/login")
    public boolean doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("se".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return true;
        }
        return false;
    }

}
