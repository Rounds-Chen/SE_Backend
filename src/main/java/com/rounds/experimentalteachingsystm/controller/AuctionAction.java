package com.rounds.experimentalteachingsystm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rounds.experimentalteachingsystm.entity.AuctionEntity;
import com.rounds.experimentalteachingsystm.service.AuctionService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-12-01
 */
@RestController
@RequestMapping("//auctionEntity")
public class AuctionAction {
    @Autowired
    AuctionService auctionService;

    /**
     * 获取拍卖信息
     * @param id 拍卖id
     * @return
     */
    @GetMapping("/getAuction")
    AjaxJson getAuction(Integer id){
        AuctionEntity res=auctionService.getById(id);
        if(res!=null){
            return AjaxJson.getSuccessData(res);
        }
        return AjaxJson.getError();
    }



}

