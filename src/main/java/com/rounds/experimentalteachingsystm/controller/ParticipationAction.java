package com.rounds.experimentalteachingsystm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rounds.experimentalteachingsystm.entity.AuctionEntity;
import com.rounds.experimentalteachingsystm.entity.ParticipationEntity;
import com.rounds.experimentalteachingsystm.service.AuctionService;
import com.rounds.experimentalteachingsystm.service.ParticipationService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.annotations.ApiIgnore;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czy
 * @since 2021-12-01
 */
@RestController
@RequestMapping("//participationEntity")
@Api
public class ParticipationAction {
    @Autowired
    ParticipationService participationService;

    @Autowired
    AuctionService auctionService;


    /**
     * 上传出价
     * @param role 参与角色：0-供给 1-需求
     * @param price 出价
     * @return
     */
    @PostMapping("/postPrice")
    @ApiOperation(value = "上传出价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId",value = "角色id",dataType = "String"),
            @ApiImplicitParam(name = "aucId",value = "拍卖id",dataType = "Integer"),
            @ApiImplicitParam(name = "role",value = "参与角色 0-供给 1-需求",dataType = "Boolean"),
            @ApiImplicitParam(name = "price",value = "出价",dataType = "BigDecimal")
    })
    public AjaxJson postPrice(@RequestParam("userId") String userId, @RequestParam("aucId") Integer aucId, @RequestParam("role") Boolean role, @RequestParam("price") Float price){
        AuctionEntity auction = auctionService.getById(aucId);
        LocalDateTime dt = LocalDateTime.now();
        if(dt.isBefore(auction.getStartTime())){
            return AjaxJson.getError("实验尚未开始!");
        }
        else if(dt.isAfter(auction.getEndTime())){
            return AjaxJson.getError("实验已经结束!");
        }

        ParticipationEntity entity=new ParticipationEntity();

        entity.setPrice(price);
        entity.setUserId(userId);
        entity.setAucId(aucId);
        entity.setRole(role);

        if(participationService.save(entity)){
            return AjaxJson.getSuccess();
        };
        return AjaxJson.getError();
    }

    /**
     * 获取某拍卖的出价信息
     * @param id 拍卖id
     * @param role 参与角色：0-供给 1-需求
     * @return
     */
    @GetMapping("/getPrice")
    @ApiOperation(value = "获取某拍卖出价信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "拍卖id",dataType = "Integer"),
            @ApiImplicitParam(name = "role",value = "参与角色 0-供给 1-需求",dataType = "Boolean")
    })
    public AjaxJson getPrice(Integer id,Boolean role){
        LambdaQueryWrapper<ParticipationEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ParticipationEntity::getAucId,id).eq(ParticipationEntity::getRole,role);

        try {
            List<ParticipationEntity> ans = participationService.list(wrapper);
            if (ans != null) {
                return AjaxJson.getSuccessData(ans);
            }
        }catch (Exception e){
            return AjaxJson.getError(e.toString());
        }
        return AjaxJson.getError();
    }

    /**
     * 获取某拍卖供给价格曲线
     * @param id 拍卖id
     * @return
     */
    @GetMapping("/getSupPriceCurve")
    @ApiOperation(value = "获取某拍卖供给曲线")
    @ApiImplicitParam(name="id",value = "拍卖id",dataType = "Integer")
   public AjaxJson getSupPriceCurve(Integer id){
        List<List<Float>> ans=participationService.getPriceCurve(id,Boolean.FALSE);
        if(ans!=null){
            return AjaxJson.getSuccessData(ans);
        }
        return AjaxJson.getError();
    }

    /**
     * 获取某拍卖需求价格曲线
     * @param id
     * @return
     */
    @GetMapping("/getDemPriceCurve")
    @ApiOperation(value = "获取某拍卖需求价格曲线")
    @ApiImplicitParam(name = "id",value = "拍卖id",type = "Integer")
    public AjaxJson getDemPriceCurve( Integer id){
        List<List<Float>> ans=participationService.getPriceCurve(id,Boolean.TRUE);
        if(ans!=null){
            return AjaxJson.getSuccessData(ans);
        }
        return AjaxJson.getError();
    }

    /**
     * 获取用户出价信息
     * @param aucId
     * @param userId
     * @return
     */
    @GetMapping("/getUserPrice")
    @ApiOperation(value = "获取用户出价信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "aucId",value = "拍卖id",dataType = "Integer"),
            @ApiImplicitParam(name = "userId",value = "用户id",dataType = "String")
    })
    public AjaxJson getUserPrice(Integer aucId, String userId){
        LambdaQueryWrapper<ParticipationEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ParticipationEntity::getAucId,aucId).eq(ParticipationEntity::getUserId,userId);

        try{
            Float price=participationService.getOne(wrapper).getPrice();
            return AjaxJson.getSuccessData(price);
        }
        catch (Exception e){
            System.out.println(e);
            return AjaxJson.getError();
        }
    }


    @GetMapping("/getWillPriceForm")
    @ApiOperation(value = "获取意愿表")
    @ApiImplicitParam(name = "id",value="拍卖id",dataType = "Integer")
    AjaxJson getWillPriceForm(Integer id){
        List<List<Float>> ans=new LinkedList<>();
        ans=participationService.getWillPriceForm(id);
        if(ans!=null){
            return AjaxJson.getSuccessData(ans);
        }

        return AjaxJson.getError();
    }


}

