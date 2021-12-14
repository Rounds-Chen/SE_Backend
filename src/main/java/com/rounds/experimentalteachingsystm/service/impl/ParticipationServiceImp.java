package com.rounds.experimentalteachingsystm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rounds.experimentalteachingsystm.entity.ParticipationEntity;
import com.rounds.experimentalteachingsystm.mapper.ParticipationMapper;
import com.rounds.experimentalteachingsystm.service.ParticipationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czy
 * @since 2021-12-01
 */
@Service
public class ParticipationServiceImp extends ServiceImpl<ParticipationMapper, ParticipationEntity> implements ParticipationService {
    @Autowired
    ParticipationMapper mapper;

    @Override
    public List<List<Float>> getPriceCurve(Integer id,Boolean role) {
        LambdaQueryWrapper<ParticipationEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ParticipationEntity::getAucId,id).eq(ParticipationEntity::getRole,0).
                select(ParticipationEntity::getPrice);
        List<Float> prices=mapper.selectObjs(wrapper).stream()
                .map(o -> (Float)o)
                .collect(Collectors.toList());
        //供给曲线（升序）
        if(!role){
            Collections.sort(prices);
        }
        //需求曲线（降序）
        else{
            Collections.sort(prices,Collections.reverseOrder());
        }
        Float prePrice= prices.get(0);
        Integer count=1;

        List<List<Float>> ans=new LinkedList<>();
        for(int i=1;i<prices.size();i++){
            if(prices.get(i)!=prePrice){
                ans.add(Arrays.asList(Float.valueOf(count),prePrice));
                if(i!=prices.size()) {
                    prePrice = prices.get(i);
                }
            }
            count+=1;
        }

        return ans;
    }

    @Override
    public List<List<Float>> getWillPriceForm(Integer id) {
        LambdaQueryWrapper<ParticipationEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ParticipationEntity::getAucId,id).
                select(ParticipationEntity::getPrice);
        List<Float> prices=mapper.selectObjs(wrapper).stream()
                .map(o -> (Float)o)
                .collect(Collectors.toList());
        Collections.sort(prices);

        List<List<Float>> ans=new LinkedList<>();
        Float count=1f;
        Float rest=Float.valueOf(prices.size());
        Float prePrice=prices.get(0);
        for(int i=1;i<prices.size();i++){
            if(prePrice!=prices.get(i)){
                ans.add(Arrays.asList(prePrice,count,rest,rest*prePrice));
                rest=rest-count;
                count=0f;
                prePrice=prices.get(i);
            }
            count+=1f;
        }
        ans.add(Arrays.asList(prePrice,count,rest,rest*prePrice));

        return ans;
    }
}
