package com.rounds.experimentalteachingsystm.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rounds.experimentalteachingsystm.entity.AuctionEntity;
import com.rounds.experimentalteachingsystm.entity.ParticipationEntity;
import com.rounds.experimentalteachingsystm.service.ParticipationService;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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
public class ParticipationAction {
    @Autowired
    ParticipationService participationService;


    /**
     * 上传出价
     * @param id 出价人id
     * @param role 参与角色：0-供给 1-需求
     * @param price 出价
     * @return
     */
    @PostMapping("/postPrice")
    AjaxJson postPrice(String id, Boolean role, BigDecimal price){
        ParticipationEntity entity=new ParticipationEntity();

        entity.setPrice(price);
        entity.setUserId(id);
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
    AjaxJson getPrice(Integer id,Boolean role){
        LambdaQueryWrapper<ParticipationEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ParticipationEntity::getId,id).eq(ParticipationEntity::getRole,role);

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


}

