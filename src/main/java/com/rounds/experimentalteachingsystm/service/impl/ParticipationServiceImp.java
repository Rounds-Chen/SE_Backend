package com.rounds.experimentalteachingsystm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rounds.experimentalteachingsystm.entity.ParticipationEntity;
import com.rounds.experimentalteachingsystm.mapper.ParticipationMapper;
import com.rounds.experimentalteachingsystm.service.ParticipationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rounds.experimentalteachingsystm.util.AjaxJson;
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
    public List<List<BigDecimal>> getPriceCurve(Integer id,Boolean role) {
        LambdaQueryWrapper<ParticipationEntity> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(ParticipationEntity::getId,id).eq(ParticipationEntity::getRole,0).
                select(ParticipationEntity::getPrice);
        List<BigDecimal> prices=mapper.selectObjs(wrapper).stream()
                .map(o -> (BigDecimal)o)
                .collect(Collectors.toList());
        //供给曲线（升序）
        if(!role){
            Collections.sort(prices);
        }
        //需求曲线（降序）
        else{
            Collections.sort(prices,Collections.reverseOrder());
        }
        BigDecimal prePrice= prices.get(0);
        Integer count=1;

        List<List<BigDecimal>> ans=new LinkedList<>();
        for(int i=1;i<prices.size();i++){
            if(prices.get(i)!=prePrice){
                ans.add(Arrays.asList(BigDecimal.valueOf(count),prePrice));
            }
            count+=1;
        }

        return ans;
    }
}
