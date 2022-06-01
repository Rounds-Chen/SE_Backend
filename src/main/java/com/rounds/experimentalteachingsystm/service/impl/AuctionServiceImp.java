package com.rounds.experimentalteachingsystm.service.impl;

import com.rounds.experimentalteachingsystm.entity.AuctionEntity;
import com.rounds.experimentalteachingsystm.mapper.AuctionMapper;
import com.rounds.experimentalteachingsystm.mapper.CoursewareMapper;
import com.rounds.experimentalteachingsystm.service.AuctionService;
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
 * @since 2021-12-01
 */
@Service
public class AuctionServiceImp extends ServiceImpl<AuctionMapper, AuctionEntity> implements AuctionService {
    @Resource
    AuctionMapper auctionMapper;
    @Override
    public List<AuctionEntity> getAllAuctionOnGoing() {
        return auctionMapper.getAllAuctionOnGoing();
    }

    @Override
    public List<AuctionEntity> getAllAuctionNotStarted() {
        return auctionMapper.getAllAuctionNotStarted();
    }
}
