package com.rounds.experimentalteachingsystm.mapper;

import com.rounds.experimentalteachingsystm.entity.AuctionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rounds.experimentalteachingsystm.entity.CoursewareEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author czy
 * @since 2021-12-01
 */
@Mapper
public interface AuctionMapper extends BaseMapper<AuctionEntity> {

    @Select("SELECT * FROM auction WHERE start_time < now() and now() < end_time")
    List<AuctionEntity> getAllAuctionOnGoing();

    @Select("SELECT * FROM auction WHERE start_time > now()")
    List<AuctionEntity> getAllAuctionNotStarted();
}
