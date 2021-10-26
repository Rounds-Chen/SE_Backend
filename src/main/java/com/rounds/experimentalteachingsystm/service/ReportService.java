package com.rounds.experimentalteachingsystm.service;

import com.rounds.experimentalteachingsystm.entity.ReportEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
public interface ReportService extends IService<ReportEntity> {

    public List<ReportEntity> getOne(int id);


}
