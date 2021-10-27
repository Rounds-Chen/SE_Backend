package com.rounds.experimentalteachingsystm.service;

import java.util.Map;

public interface LoginService {
    /**
     * 检查该用户id是否存在
     * @param id
     * @return
     */
    public boolean checkID(String id);

    public Map<String, Integer> doLogin(String id, String pwd);
}
