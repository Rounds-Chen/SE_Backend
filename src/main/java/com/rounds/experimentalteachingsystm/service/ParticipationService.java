package com.rounds.experimentalteachingsystm.service;

import com.rounds.experimentalteachingsystm.entity.ParticipationEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czy
 * @since 2021-12-01
 */
public interface ParticipationService extends IService<ParticipationEntity> {
    public List<List<Float>> getPriceCurve(Integer id,Boolean role);

    public List<List<Float>> getWillPriceForm(Integer id);

}
