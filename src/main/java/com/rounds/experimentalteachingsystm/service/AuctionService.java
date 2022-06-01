package com.rounds.experimentalteachingsystm.service;

import com.rounds.experimentalteachingsystm.entity.AuctionEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czy
 * @since 2021-12-01
 */
public interface AuctionService extends IService<AuctionEntity> {

    List<AuctionEntity> getAllAuctionOnGoing();

    List<AuctionEntity> getAllAuctionNotStarted();
}
