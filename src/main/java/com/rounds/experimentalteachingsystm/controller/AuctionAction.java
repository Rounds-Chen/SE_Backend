package com.rounds.experimentalteachingsystm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rounds.experimentalteachingsystm.entity.AuctionEntity;
import com.rounds.experimentalteachingsystm.service.AuctionService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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
@Api
public class AuctionAction {
    @Autowired
    AuctionService auctionService;



    @GetMapping("//getAllAuction")
    @ApiOperation(value = "获取所有拍卖")
    AjaxJson getAllCourses(){
        return AjaxJson.getSuccessData(auctionService.list());
    }
    /**
     * 获取拍卖信息
     * @param id 拍卖id
     * @return
     */
    @GetMapping("/getAuction")
    @ApiImplicitParam(name = "id",value = "拍卖id",type = "Integer")
    public AjaxJson getAuction(Integer id){
        AuctionEntity res=auctionService.getById(id);
        if(res!=null){
            return AjaxJson.getSuccessData(res);
        }
        return AjaxJson.getError();
    }

    @PostMapping("/postAuction")
    @ApiOperation(value = "发布拍卖")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "initiatorId",value = "发布人id",dataType = "String"),
            @ApiImplicitParam(name = "title",value = "拍卖标题",dataType = "String"),
            @ApiImplicitParam(name = "des",value = "拍卖描述",dataType = "String"),
    })
    public AjaxJson postAuction(@RequestParam("initiatorId")String initiatorId,@RequestParam("title") String title,  @RequestParam("des") String des){
        AuctionEntity entity=new AuctionEntity();
        entity.setAuctionTitle(title);
        entity.setDescription(des);
//        entity.setStartTime(begin);??
//        entity.setEndTime(end);
        entity.setInitiatorId(initiatorId);
        entity.setBalancePrice(BigDecimal.valueOf(0));

        if(auctionService.save(entity)){
            Map<String,Integer> res=new HashMap<>();
            res.put("auction_id",entity.getAuctionId());
            return AjaxJson.getSuccessData(res);
        };
        return AjaxJson.getError();

    }



}

