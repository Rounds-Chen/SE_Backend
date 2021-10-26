package com.rounds.experimentalteachingsystm.service.impl;

import com.rounds.experimentalteachingsystm.entity.ReportEntity;
import com.rounds.experimentalteachingsystm.mapper.ReportMapper;
import com.rounds.experimentalteachingsystm.service.ReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czy
 * @since 2021-10-25
 */
@Service
public class ReportServiceImp extends ServiceImpl<ReportMapper, ReportEntity> implements ReportService {

    @Resource
    ReportMapper reportMapper;

    @Override
    public List<ReportEntity> getOne(int id) {
        return reportMapper.getOne(1);
    }
}
