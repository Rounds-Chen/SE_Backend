package com.rounds.experimentalteachingsystm.service;

public interface LoginService {
    /**
     * 检查该用户id是否存在
     * @param id
     * @return
     */
    public boolean checkID(String id);
}
