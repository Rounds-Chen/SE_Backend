package com.rounds.experimentalteachingsystm.service;

import cn.dev33.satoken.stp.SaTokenInfo;

import java.util.Map;

public interface LoginService {
    /**
     * 检查该用户id是否存在
     * @param id
     * @return
     */
    public boolean checkID(String id);

    public SaTokenInfo doLogin(String id, String pwd);
}
